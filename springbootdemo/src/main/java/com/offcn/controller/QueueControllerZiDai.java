package com.offcn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueControllerZiDai {

	@Autowired
	private JmsMessagingTemplate JmsMessagingTemplate;
	
	@RequestMapping("/sendMap")
	public void sendMap() {
		Map map = new HashMap();
		map.put("name", "老王");
		map.put("pwd", "123");
		JmsMessagingTemplate.convertAndSend("map", map);
	}
	
}





















