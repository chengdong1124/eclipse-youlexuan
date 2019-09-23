package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统自带的mq
 * @author Administrator
 *
 */
@RestController   
public class QueueController {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@RequestMapping("/send")
	public void setMessage(String textMsg) {
		jmsMessagingTemplate.convertAndSend("brand", textMsg);
		
		
	}

}
