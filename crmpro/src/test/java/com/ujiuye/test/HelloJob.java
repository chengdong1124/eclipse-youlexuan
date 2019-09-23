package com.ujiuye.test;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		//获取传入的参数
		JobDataMap data = context.getJobDetail().getJobDataMap(); 
		String email = data.getString("email");
		//打印当前的执行时间 例如 2017-11-22 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("现在的时间是："+ sf.format(date));
        //具体的业务逻辑
        System.out.println("开始生成任务报表 或 开始发送邮件");
        System.out.println("email"+email);
	
	}

}
