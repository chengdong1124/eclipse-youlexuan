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
 * 分页查询
 * @author Administrator
 *
 */
public class DemoTest5 {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-solr.xml");
		SolrTemplate solrTemplate = (SolrTemplate)app.getBean("solrTemplate");
	
		Query query = new SimpleQuery("*:*");//查询所有
		
		Criteria criteria = new Criteria("title").contains("程序");
		
		query.addCriteria(criteria);
	
		ScoredPage<TbItem> list = solrTemplate.queryForPage(query,TbItem.class);
		
		long total = list.getTotalElements();
		System.out.println(total+"总数");
		
		List<TbItem> items = list.getContent();
		
		for (TbItem tbItem : items) {
			System.out.println(tbItem.getId());
			System.out.println(tbItem.getTitle());
		}
		
	}

}















