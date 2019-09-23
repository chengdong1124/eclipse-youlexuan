package com.ujiuye.test;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Demo {

	@Test
	public void sendSimpleEmail() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.qq.com");// ָ����������Email���ʼ�������������
		mailSender.setPort(25);// Ĭ�϶˿ڣ���׼��SMTP�˿�
		mailSender.setUsername("839682910@qq.com");// �û���
		mailSender.setPassword("nhebjjznqdfsbcjj");// ����/��Ȩ��

		SimpleMailMessage message = new SimpleMailMessage();// ��Ϣ������
		message.setFrom("839682910@qq.com");// ������
		message.setTo("1017969905@qq.com");// �ռ���
		message.setSubject("��־�����ʺ���֤");// ����
		message.setText("��־�����ʺ���֤:456879");// ����
		mailSender.send(message);
		System.out.println("�ʼ��������");
	}

	@Test
	public void sendCode() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.qq.com");// ָ����������Email���ʼ�������������
		mailSender.setPort(25);// Ĭ�϶˿ڣ���׼��SMTP�˿�
		mailSender.setUsername("839682910@qq.com");// �û���
		mailSender.setPassword("nhebjjznqdfsbcjj");// ����/��Ȩ��

		String code = "5666";

		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(msg, true, "utf-8");
			helper.setFrom("839682910@qq.com");
			helper.setTo("1017969905@qq.com");
			helper.setSubject("���ж�������ϵͳ����֤");
			// �ڶ�������true����ʾtext������Ϊhtml��Ȼ��ע��<img/>��ǩ��src='cid:file'��'cid'��contentId����д��'file'��һ����ǣ���Ҫ�ں���Ĵ����е���MimeMessageHelper��addInline����������ļ�
			helper.setText(
					"		<div style='width: 320px; margin: 0 auto; background-color: darkblue; color: white; padding: 20px 40px 40px;'>\r\n"
							+ "			<p style='font-size: 24px;'>������������֤�룺</p>\r\n"
							+ "			<p style='font-size: 24px; color: chartreuse;'>" + code + "</p>\r\n"
							+ "			<p>�����ã�</p>\r\n"
							+ "			<p>�����յ����������ĳ��ж�����ϵͳͨ��֤�İ�ȫ������ʹ���������֤����֤�����˺Ź���</p>\r\n"
							+ "			<p>��ע�⣺����֤�뽫��10���Ӻ���ڣ��뾡����֤��</p>\r\n" + "		</div>\r\n",
					true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		mailSender.send(msg);
		System.out.println("�ʼ��������");
	}

	/**
	 * ���ʹ��и�����email
	 * 
	 * @throws MessagingException
	 */
	@Test
	public void sendEmailWithAttachment() throws MessagingException {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.qq.com");// ָ����������Email���ʼ�������������
		mailSender.setPort(25);// Ĭ�϶˿ڣ���׼��SMTP�˿�
		mailSender.setUsername("839682910@qq.com");// �û���
		mailSender.setPassword("nhebjjznqdfsbcjj");// ����

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);// ������Ϣhelper���ڶ����������������Ϣ��multipart���͵�
		helper.setFrom("839682910@163.com");
		helper.setTo("1017969905@qq.com");
		helper.setSubject("Spring Email Test");
		helper.setText("����һ�����и�������Ϣ");
		// ʹ��Spring��FileSystemResource������fox.png
		FileSystemResource image = new FileSystemResource("D:\\fox.png");
		System.out.println(image.exists());
		helper.addAttachment("fox.png", image);// ��Ӹ��ӣ���һ������Ϊ��ӵ�Email�и��������ƣ��ڶ����˲�����ͼƬ��Դ
		mailSender.send(message);
		System.out.println("�ʼ��������");
	}

}