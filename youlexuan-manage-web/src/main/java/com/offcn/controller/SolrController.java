package com.offcn.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.offcn.common.Result;
import com.offcn.pojo.TbItem;
import com.offcn.service.ItemService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/solr")
public class SolrController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private SolrTemplate solrTemplate;
	
	@RequestMapping("/importSolr")
	public Result importSolr() {
		try {
			List<TbItem> list = itemService.importSolr();
			for (TbItem tbItem : list) {
				Map specMap = JSON.parseObject(tbItem.getSpec(),Map.class);
				tbItem.setSpecMap(specMap);
			}
			solrTemplate.saveBeans(list);
			solrTemplate.commit();
			return new Result(true,"成功");
		} catch (Exception e) {
			return new Result(false,"失败");
		}
	}
	
	@RequestMapping("/deleteSolr")
	public Result deleteSolr() {
		try {
			Query query = new SimpleQuery("*:*");
			solrTemplate.delete(query);
			solrTemplate.commit();
			return new Result(true,"成功");
		} catch (Exception e) {
			return new Result(false,"失败");
		}
	}
	
	

}



















