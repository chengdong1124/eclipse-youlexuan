package com.ujiuye.crmpro.utils;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ujiuye.crmpro.message.pojo.Email;

public class EmailJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//从JobDetail中获取参数
		JobDataMap map = context.getJobDetail().getJobDataMap();
		Email email = (Email) map.get("email");
		//调用工具类
		EmailUtils.sent(email);
	}
	
}
