package com.offcn.service;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QueueConsumerDemo {

	public static void main(String[] args) throws IOException {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-mq.xml");
		System.in.read();
	}

}
