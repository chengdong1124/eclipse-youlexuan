package com.ujiuye.customer;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class CustomerDemo3 {

	public static void main(String[] args) throws Exception {
		String url="tcp://192.168.59.132:61616";
		//获取mq的连接，通过连接工厂
		ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory(url);
		//获取连接对象
		Connection connection = mqConnectionFactory.createConnection();
		//开启连接
		connection.start();
		//第一个参数是否启用事务，第二个参数制定消息确定方法
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		//创建消息队列
		Topic topic = session.createTopic("多对多");
		//获取消费者
		MessageConsumer consumer = session.createConsumer(topic);
		//监听消息
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage)message;
				try {
					System.out.println(textMessage.getText());
					System.out.println("接受成功");
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		
		//等待
		System.in.read();
		
		//关闭资源
		consumer.close();
		session.close();
		connection.close();

	}

}
