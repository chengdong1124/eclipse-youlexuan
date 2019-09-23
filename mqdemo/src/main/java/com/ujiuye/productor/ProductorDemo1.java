package com.ujiuye.productor;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ProductorDemo1 {

	public static void main(String[] args) throws JMSException {

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
		Queue queue = session.createQueue("test_point_to_point");
		//获取成产者
		MessageProducer producer = session.createProducer(queue);
		//获取消息
		TextMessage textMessage = session.createTextMessage("呵呵");
		//发送消息
		producer.send(textMessage);
		System.out.println("发送成功");
		//关闭资源
		producer.close();
		session.close();
		connection.close();
	}

}














