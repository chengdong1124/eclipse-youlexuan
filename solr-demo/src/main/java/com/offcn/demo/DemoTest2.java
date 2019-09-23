package com.offcn.demo;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;

import com.offcn.pojo.TbItem;

/**
 * 查询数据
 * @author Administrator
 *
 */
public class DemoTest2 {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-solr.xml");
		SolrTemplate solrTemplate = (SolrTemplate)app.getBean("solrTemplate");
		
		
		TbItem tbItem = solrTemplate.getById(1,TbItem.class);
		System.out.println(tbItem.getTitle());
	}

}















