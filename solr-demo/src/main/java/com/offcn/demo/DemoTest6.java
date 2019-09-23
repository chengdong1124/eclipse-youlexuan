package com.offcn.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import com.offcn.pojo.TbItem;

/**
 * 删除数据
 * @author Administrator
 *
 */
public class DemoTest6 {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-solr.xml");
		SolrTemplate solrTemplate = (SolrTemplate)app.getBean("solrTemplate");
	
		Query query = new SimpleQuery("*:*");
		solrTemplate.delete(query);
		solrTemplate.commit();
		System.out.println("删除成功");
	
		
	}

}















