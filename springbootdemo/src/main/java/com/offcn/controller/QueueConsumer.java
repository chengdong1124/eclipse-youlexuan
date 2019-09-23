package com.offcn.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

@RestController      //不加注解就没法扫描这个类，就没有下文了
public class QueueConsumer {

	@JmsListener(destination = "brand")   //绑定消息队列
	public void getMessage(String textMsg) {
		System.out.println(textMsg);
	}

}
