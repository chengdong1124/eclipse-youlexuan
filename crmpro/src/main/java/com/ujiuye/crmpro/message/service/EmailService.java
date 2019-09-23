package com.ujiuye.crmpro.message.service;

import com.ujiuye.crmpro.message.pojo.Email;

public interface EmailService {
	
	boolean send(Email email,String isTime);

}
