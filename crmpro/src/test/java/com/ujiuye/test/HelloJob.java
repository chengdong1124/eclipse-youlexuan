package com.ujiuye.test;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		//��ȡ����Ĳ���
		JobDataMap data = context.getJobDetail().getJobDataMap(); 
		String email = data.getString("email");
		//��ӡ��ǰ��ִ��ʱ�� ���� 2017-11-22 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("���ڵ�ʱ���ǣ�"+ sf.format(date));
        //�����ҵ���߼�
        System.out.println("��ʼ�������񱨱� �� ��ʼ�����ʼ�");
        System.out.println("email"+email);
	
	}

}
