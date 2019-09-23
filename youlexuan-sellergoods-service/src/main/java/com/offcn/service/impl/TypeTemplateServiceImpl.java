package com.offcn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.offcn.common.PageResult;
import com.offcn.dao.TbSpecificationOptionMapper;
import com.offcn.dao.TbTypeTemplateMapper;
import com.offcn.pojo.TbSpecificationOption;
import com.offcn.pojo.TbSpecificationOptionExample;
import com.offcn.pojo.TbTypeTemplate;
import com.offcn.pojo.TbTypeTemplateExample;
import com.offcn.pojo.TbTypeTemplateExample.Criteria;
import com.offcn.service.TypeTemplateService;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

	@Autowired
	private TbTypeTemplateMapper type_templateMapper;

	@Autowired
	private TbSpecificationOptionMapper tbSpecificationOptionMapper;
	
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbTypeTemplate> findAll() {
		return type_templateMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbTypeTemplate> page = (Page<TbTypeTemplate>) type_templateMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbTypeTemplate type_template) {
		type_templateMapper.insert(type_template);
	}

	/**
	 * 修改
	 */
	@Override
	public void update(TbTypeTemplate type_template) {
		type_templateMapper.updateByPrimaryKey(type_template);
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public TbTypeTemplate findOne(Long id) {
		return type_templateMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			type_templateMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult findPage(TbTypeTemplate type_template, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TbTypeTemplateExample example = new TbTypeTemplateExample();
		Criteria criteria = example.createCriteria();

		if (type_template != null) {
			if (type_template.getName() != null && type_template.getName().length() > 0) {
				criteria.andNameLike("%" + type_template.getName() + "%");
			}
		}
		// 他把查询到的结果封装在page中，page当中就有那个相当于带分页的list集合，而这个集合就是page.getResult()
		Page<TbTypeTemplate> page = (Page<TbTypeTemplate>) type_templateMapper.selectByExample(example);
		
		//放在上一行代码之前会报错
		//原因我们在saveBrandAndSpecToRedis中调用了findAll有分页
		saveBrandAndSpecToRedis();
		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
	
	private void saveBrandAndSpecToRedis() {
		List<TbTypeTemplate> list = findAll();
		
		for (TbTypeTemplate tbTypeTemplate : list) {
			List<Map> brandsList = JSON.parseArray(tbTypeTemplate.getBrandIds(),Map.class);
			List<Map> SpecList = findSpecList(tbTypeTemplate.getId());
			redisTemplate.boundHashOps("brandsList").put(tbTypeTemplate.getId(), brandsList);
			redisTemplate.boundHashOps("SpecList").put(tbTypeTemplate.getId(), SpecList);
		}
	}
	

	@Override
	public List<Map> findSpecList(long id) {
		TbTypeTemplate tbTypeTemplate = type_templateMapper.selectByPrimaryKey(id);
		// [{"id":27,"text":"网络制式"},{"id":32,"text":"机身内存"}]

		JSONArray parseArray = JSON.parseArray(tbTypeTemplate.getSpecIds());
		// [{"id":27,"text":"网络制式"},{"id":32,"text":"机身内存"}]

		List<Map> list = JSON.parseArray(tbTypeTemplate.getSpecIds(), Map.class);
		// [{id=27, text=网络制式}, {id=32, text=机身内存}]
		// [id=27,text=网络制式,id=32, text=机身内存]这就是个map
		// list里面存的是map集合，而不是说list里面的对象是map键值对

		for (Map map : list) {
			TbSpecificationOptionExample example = new TbSpecificationOptionExample();
			com.offcn.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
			// criteria.andSpecIdEqualTo((Long)map.get("id"));
			criteria.andSpecIdEqualTo(new Long((Integer) map.get("id")));
			List<TbSpecificationOption> options = tbSpecificationOptionMapper.selectByExample(example);
			map.put("options", options);
			//{id=27, text=网络制式,options=[]}
		}
		return list;
	}

}
