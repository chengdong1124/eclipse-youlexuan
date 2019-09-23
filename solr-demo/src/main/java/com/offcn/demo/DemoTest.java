package com.offcn.demo;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;

import com.offcn.pojo.TbItem;

/**
 * 存数据
 * @author Administrator
 *
 */
public class DemoTest {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-solr.xml");
		SolrTemplate solrTemplate = (SolrTemplate)app.getBean("solrTemplate");
		
		TbItem tbItem = new TbItem();
		tbItem.setId(1L);
		tbItem.setBrand("华为");
		tbItem.setTitle("测试solr");
		tbItem.setCategory("手机");
		//一定要记得commit啊
		solrTemplate.saveBean(tbItem);
		solrTemplate.commit();
		System.out.println("保存成功");
		
	}

}















