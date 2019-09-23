package com.offcn.demo;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import com.offcn.pojo.TbItem;

/**
 * 分页查询
 * @author Administrator
 *
 */
public class DemoTest3 {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-solr.xml");
		SolrTemplate solrTemplate = (SolrTemplate)app.getBean("solrTemplate");
	
//添加假数据
		List<TbItem> list = new ArrayList();
		for (long i =0;i < 100;i++) {
			TbItem tbItem = new TbItem();
			tbItem.setId(i);
			tbItem.setBrand("华为");
			tbItem.setTitle("测试solr");
			tbItem.setCategory("手机");
			list.add(tbItem);
		}
		solrTemplate.saveBean(list);
		solrTemplate.commit();
		
		Query query = new SimpleQuery("*:*");//查询所有
		//设置分页的条件
		query.setOffset(0);//开始索引
		query.setRows(20);//每页的数据
		//分页查询
		ScoredPage<TbItem> queryForPage = solrTemplate.queryForPage(query, TbItem.class);	
		System.out.println("总条目数"+queryForPage.getTotalElements());
		List<TbItem> items = queryForPage.getContent(); //每一页的数据
		for (TbItem tbItem : items) {
			System.out.println(tbItem.getId());
		}
	}

}















