package com.ujiuye.crmpro.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.employee.pojo.Archives;
import com.ujiuye.crmpro.employee.service.ArchivesService;
import com.ujiuye.crmpro.message.pojo.Email;
import com.ujiuye.crmpro.utils.EmailScheduler;
import com.ujiuye.crmpro.utils.EmailUtils;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private ArchivesService archivesService;
	
	
	@Override
	public boolean send(Email email,String isTime) {
		Archives archives = archivesService.getByEmpFk(Integer.parseInt(email.getSendto()));
		if(archives==null) {	//这个人竟然没有采集档案，多可怕
			return false;
		}
		email.setSendto(archives.getEmail());
		if(isTime.equals("on")) {
			EmailScheduler.send(email);
			return true;
		}else {
			return EmailUtils.sent(email);
		}
		
	}
}
