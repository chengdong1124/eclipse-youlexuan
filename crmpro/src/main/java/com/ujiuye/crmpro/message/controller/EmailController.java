package com.ujiuye.crmpro.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujiuye.crmpro.message.pojo.Email;
import com.ujiuye.crmpro.message.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("send")
	@ResponseBody
	public String send(Email email,String isTime) {
		
		if(emailService.send(email,isTime)) {
			return "true";
		}
		return "false";
		
	}
}


















