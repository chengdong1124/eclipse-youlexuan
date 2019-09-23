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
	        
	        //���������ж�̬����
	        jobDetail.getJobDataMap().put("email",email);
	        
	        //Schedulerʵ��
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
				        .startAt(format.parse(time))//�趨����ʱ��
				        .withSchedule(
				                SimpleScheduleBuilder.simpleSchedule()
				                        .withIntervalInSeconds(3)
				                        .withRepeatCount(0))//�ظ�ִ�еĴ�������Ϊ���������ʱ������ִ���ˣ����Բ���Ҫ�ظ���������һ�Ρ�
				        .build();
				scheduler.scheduleJob(jobDetail, simpleTrigger);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	        
	}
}
