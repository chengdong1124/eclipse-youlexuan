package com.ujiuye.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class CronScheduler {
	public static void main(String[] args) throws SchedulerException, InterruptedException, ParseException {
        //jobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("cronJob").build();
        
        //���������ж�̬����
        jobDetail.getJobDataMap().put("email","hello");
        jobDetail.getJobDataMap().put("title","title yes");
        jobDetail.getJobDataMap().put("content","content yes");
        
        //Schedulerʵ��
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();

        String t="2019-08-08 17:29:00";
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group1")
                .startAt(format.parse(t))//�趨����ʱ��
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(3)
                                .withRepeatCount(0))//�ظ�ִ�еĴ�������Ϊ���������ʱ������ִ���ˣ����Բ���Ҫ�ظ���������һ�Ρ�
                .build();
        scheduler.scheduleJob(jobDetail, simpleTrigger);

    }
}












