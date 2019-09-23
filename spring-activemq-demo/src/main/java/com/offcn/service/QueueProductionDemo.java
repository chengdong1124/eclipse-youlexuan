package com.offcn.service;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;



public class QueueProductionDemo {

// 想要用注解可以，得需要有扫描扫描到上面的那个类，同时还要这个类的需要有注解，才能注解下面的属性（依赖注入）
//	@Autowired
//	private static JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		
		
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-mq.xml");
		//获取jms模板对象
		JmsTemplate jmsTemplate = (JmsTemplate)app.getBean("jmsTemplate");
		//获取消息队列
		ActiveMQTopic queue = (ActiveMQTopic)app.getBean("activeMQTopic");
		
		jmsTemplate.send(queue,new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Map map = new HashMap();
				map.put("name", "老王");
				map.put("pwd", "123");
				TextMessage msg = session.createTextMessage("好不好玩");
				System.out.println("发送成功");
				return msg;
			}
		});
		
	}
}












