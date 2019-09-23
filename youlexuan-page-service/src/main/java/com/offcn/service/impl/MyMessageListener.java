package com.offcn.service.impl;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.offcn.service.ItemPageService;

public class MyMessageListener implements MessageListener{
	
	@Autowired
	private ItemPageService itemPageService;
	
	@Override
	public void onMessage(Message message) {
		
		TextMessage textMessage = (TextMessage)message;
		try {
			String text = textMessage.getText();
			
			//ItemPageServiceImpl itemPageServiceImpl = new ItemPageServiceImpl();
			
			boolean itemHtml = itemPageService.getItemHtml(Long.parseLong(text));
			
			System.out.println(itemHtml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
