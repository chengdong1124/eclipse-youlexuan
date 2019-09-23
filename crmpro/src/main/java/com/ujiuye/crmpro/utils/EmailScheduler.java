package com.ujiuye.crmpro.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.ujiuye.crmpro.message.pojo.Email;

public class EmailScheduler {
	public static void send(Email email) {
		 JobDetail jobDetail = JobBuilder.newJob(EmailJob.class).withIdentity("cronJob").build();
	        
	        //向任务器中动态传参
	        jobDetail.getJobDataMap().put("email",email);
	        
	        //Scheduler实例
	        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
	        Scheduler scheduler = null;
			try {
				scheduler = stdSchedulerFactory.getScheduler();
				scheduler.start();
			} catch (SchedulerException e) {
				
				e.printStackTrace();
			}
	        
			String time = email.getTime();
	        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        SimpleTrigger simpleTrigger;
			try {
				simpleTrigger = TriggerBuilder.newTrigger()
				        .withIdentity("trigger3", "group1")
				        .startAt(format.parse(time))//设定发送时间
				        .withSchedule(
				                SimpleScheduleBuilder.simpleSchedule()
				                        .withIntervalInSeconds(3)
				                        .withRepeatCount(0))//重复执行的次数，因为加入任务的时候马上执行了，所以不需要重复，否则会多一次。
				        .build();
				scheduler.scheduleJob(jobDetail, simpleTrigger);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	        
	}
}
