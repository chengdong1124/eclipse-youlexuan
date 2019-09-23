package com.offcn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FilterQuery;
import org.springframework.data.solr.core.query.GroupOptions;
import org.springframework.data.solr.core.query.HighlightOptions;
import org.springframework.data.solr.core.query.HighlightQuery;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleFilterQuery;
import org.springframework.data.solr.core.query.SimpleHighlightQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.GroupEntry;
import org.springframework.data.solr.core.query.result.GroupPage;
import org.springframework.data.solr.core.query.result.GroupResult;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.dubbo.common.json.JSONObject;
import com.offcn.dao.TbItemMapper;
import com.offcn.pojo.TbItem;
import com.offcn.pojo.TbItemExample;
import com.offcn.service.ItemSearchService;

@Service
public class ItemSearchServiceImpl implements ItemSearchService {

	@Autowired
	private SolrTemplate solrTemplate;

	@Autowired
	private TbItemMapper TbItemMapper;

	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public Map<String, Object> search(Map searchMap) {

		Map<String, Object> map = new HashMap();
		// 高亮
		Map map1 = searchHiglight(searchMap);

		// putAll可以合并两个MAP，只不过如果有相同的key那么用后面的覆盖前面的
		map.putAll(map1);

		// 查询分类
		List categoryList = searchCategoryList(searchMap);

		map.put("categoryList", categoryList);

		// 根据分类信息查询规格和品牌
		if (categoryList.size() > 0) {
			Map brandAndSpecMap = searchBrand((String) categoryList.get(0));
			map.putAll(brandAndSpecMap);
		}
		return map;
	}

	// 高亮显示
	private Map searchHiglight(Map searchMap) {
		//多关键字查询
		String value = (String)searchMap.get("key");
		
		if(value.contains(" ")) {
			String searchName = value.replace(" ", "");
			searchMap.put("key", searchName);
		}
		
		Map<String, Object> map = new HashMap();

		HighlightQuery query = new SimpleHighlightQuery();

		HighlightOptions options = new HighlightOptions().addField("title");// 设置高亮的字段

		options.setSimplePrefix("<em style='color:red'>");

		options.setSimplePostfix("</em>");

		query.setHighlightOptions(options);

		// 获取在搜索框输入的
		Criteria criteria = new Criteria("item_keywords").is(searchMap.get("key"));

		query.addCriteria(criteria);

		// 分类查询
		// 根据分类条件查询
		if (!"".equals(searchMap.get("category"))) {

			Criteria criteria1 = new Criteria("category").is(searchMap.get("category"));

			FilterQuery filterQuery = new SimpleFilterQuery(criteria1);

			query.addFilterQuery(filterQuery);

		}

		if (!"".equals(searchMap.get("brand"))) {

			Criteria criteria1 = new Criteria("brand").is(searchMap.get("brand"));

			FilterQuery filterQuery = new SimpleFilterQuery(criteria1);

			query.addFilterQuery(filterQuery);

		}

		if (null != searchMap.get("spec")) {// {}不为null，100%进来
											// 从前台传来的 @RequestBody 并没有把searchMap.get("spec")
											// 也同样转成map，还是个json字符串，所以在后面遍历不会报空指针，

			Map<String, String> specMap = (Map) searchMap.get("spec");// {} map形式的json字符串吗

			// Map map2 = JSONObject(searchMap.get("spec"), Map.class); 而这样转换成对象了，所以会报空指针

			for (String key : specMap.keySet()) {
				Criteria specCriteria = new Criteria("item_spec_" + key).is(specMap.get(key));
				FilterQuery filterQuery = new SimpleFilterQuery(specCriteria);
				query.addFilterQuery(filterQuery);
			}
		}

		if (!"".equals(searchMap.get("price"))) {
			
			String[] split = ((String) searchMap.get("price")).split("-");
			
			if (!split[0].equals("0")) {
				
				Criteria criteria1 = new Criteria("price").greaterThanEqual(split[0]);
				FilterQuery filterQuery = new SimpleFilterQuery(criteria1);
				query.addFilterQuery(filterQuery);
			}
			if (!split[1].equals("*")) {

				Criteria criteria1 = new Criteria("price").lessThanEqual(split[1]);
				FilterQuery filterQuery = new SimpleFilterQuery(criteria1);
				query.addFilterQuery(filterQuery);
			}
		}
		
		Integer pageNo= (Integer) searchMap.get("pageNo");//提取页码
		if(pageNo==null){
			pageNo=1;//默认第一页
		}
		Integer pageSize=(Integer) searchMap.get("pageSize");//每页记录数 
		if(pageSize==null){
			pageSize=20;//默认20
		}
		query.setOffset((pageNo-1)*pageSize);//从第几条记录查询
		query.setRows(pageSize);

		//价格的升序与降序
		String sortstr = (String)searchMap.get("sort");
		String sortFile = (String)searchMap.get("sortFile");
		if(sortFile != null && !sortFile.equals("")) {
			if(sortstr.equals("ASC")) {
				Sort sort = new Sort(Sort.Direction.ASC,sortFile);
				query.addSort(sort);
			}
			if(sortstr.equals("DESC")) {
				Sort sort = new Sort(Sort.Direction.DESC,sortFile);
				query.addSort(sort);
			}
		}
		
		
		

		HighlightPage<TbItem> page = solrTemplate.queryForHighlightPage(query, TbItem.class);

		for (HighlightEntry<TbItem> h : page.getHighlighted()) {

			TbItem tbItem = h.getEntity();

			if (h.getHighlights().size() > 0 && h.getHighlights().get(0).getSnipplets().size() > 0) {

				tbItem.setTitle(h.getHighlights().get(0).getSnipplets().get(0));
			}
		}

		List<TbItem> list = page.getContent();

		map.put("rows", list);
		
		map.put("totalPages", page.getTotalPages());//返回总页数
		
		map.put("total", page.getTotalElements());//返回总记录数

		return map;
	}

	// 根据输入的查询条件，获取分类的列表
	private List searchCategoryList(Map searchMap) {

		List<String> list = new ArrayList();

		Query query = new SimpleQuery();// 写不写*:*都一样，都是查全部

		Criteria criteria = new Criteria("item_keywords").is(searchMap.get("key"));

		query.addCriteria(criteria);

		GroupOptions groupOptions = new GroupOptions().addGroupByField("category");

		query.setGroupOptions(groupOptions);

		// 获取查询所有的结果集
		GroupPage<TbItem> page = solrTemplate.queryForGroupPage(query, TbItem.class);

		// 根据所有的结果集获取分组集
		GroupResult<TbItem> groupResult = page.getGroupResult("category");

		// 获取分组结果的入口
		Page<GroupEntry<TbItem>> groupEntries = groupResult.getGroupEntries();

		// 获取每一页的数据
		List<GroupEntry<TbItem>> content = groupEntries.getContent();

		// 遍历获取分组集中的TbItem对象
		for (GroupEntry<TbItem> gentry : content) {

			String groupValue = gentry.getGroupValue();

			list.add(groupValue);
		}

		return list;
	}

	/**
	 * 根据输入的查询条件查询分类，然后根据分类查询品牌
	 */
	private Map searchBrand(String category) {
		Map map = new HashMap();
		// 当很多用户每次在搜索的时候都会调用数据库查询的方法（一直在访问数据库）
		// 所以在这个地方，我们应该把category查询的品牌放到缓存中

		Long typeId = (Long) redisTemplate.boundHashOps("itemCat").get(category);
		// 变成Long,就不在是long这样的基本类型了就可以用null判断
		if (typeId != null) {
			List<Map> brandsList = (List<Map>) redisTemplate.boundHashOps("brandsList").get(typeId);

			List<Map> specList = (List<Map>) redisTemplate.boundHashOps("SpecList").get(typeId);

			// 把查询的规格和品牌保存到map中
			map.put("brandsList", brandsList);
			map.put("specList", specList);

		}
		return map;
	}

}
