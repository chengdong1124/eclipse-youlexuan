package com.ujiuye.crmpro.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.ujiuye.crmpro.message.pojo.Email;

public class EmailUtils {

	public static boolean sent(Email email) {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.qq.com");// ָ����������Email���ʼ�������������
		mailSender.setPort(25);// Ĭ�϶˿ڣ���׼��SMTP�˿�
		mailSender.setUsername("839682910@qq.com");// �û���
		mailSender.setPassword("nhebjjznqdfsbcjj");// ����/��Ȩ��
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(msg, true, "utf-8");
			helper.setFrom("839682910@qq.com");// ������
			helper.setTo(email.getSendto());// �ռ���
			helper.setSubject(email.getTitle());
			// �ڶ�������true����ʾtext������Ϊhtml��Ȼ��ע��<img/>��ǩ��src='cid:file'��'cid'��contentId����д��'file'��һ����ǣ���Ҫ�ں���Ĵ����е���MimeMessageHelper��addInline����������ļ�
			helper.setText(email.getContent(), true);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		mailSender.send(msg);
		System.out.println("�ʼ��������");
		return true;

	}

}
















