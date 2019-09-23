package com.ujiuye.crmpro.message.service;

import java.util.List;

import com.ujiuye.crmpro.message.pojo.Message;

public interface MessageService {
	
	List<Message> listByType(int receive,String key,int type);
	
	Message getById(int id);
	
	boolean update(Message message);
	
	int countByStatus(int receive,int status);
	
	boolean save(Message message);

}
