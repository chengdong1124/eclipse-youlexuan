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
		mailSender.setHost("smtp.qq.com");// 指定用来发送Email的邮件服务器主机名
		mailSender.setPort(25);// 默认端口，标准的SMTP端口
		mailSender.setUsername("839682910@qq.com");// 用户名
		mailSender.setPassword("nhebjjznqdfsbcjj");// 密码/授权码

		SimpleMailMessage message = new SimpleMailMessage();// 消息构造器
		message.setFrom("839682910@qq.com");// 发件人
		message.setTo("1017969905@qq.com");// 收件人
		message.setSubject("凌志网络帐号验证");// 主题
		message.setText("凌志网络帐号验证:456879");// 正文
		mailSender.send(message);
		System.out.println("邮件发送完毕");
	}

	@Test
	public void sendCode() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.qq.com");// 指定用来发送Email的邮件服务器主机名
		mailSender.setPort(25);// 默认端口，标准的SMTP端口
		mailSender.setUsername("839682910@qq.com");// 用户名
		mailSender.setPassword("nhebjjznqdfsbcjj");// 密码/授权码

		String code = "5666";

		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(msg, true, "utf-8");
			helper.setFrom("839682910@qq.com");
			helper.setTo("1017969905@qq.com");
			helper.setSubject("超市订单管理系统号验证");
			// 第二个参数true，表示text的内容为html，然后注意<img/>标签，src='cid:file'，'cid'是contentId的缩写，'file'是一个标记，需要在后面的代码中调用MimeMessageHelper的addInline方法替代成文件
			helper.setText(
					"		<div style='width: 320px; margin: 0 auto; background-color: darkblue; color: white; padding: 20px 40px 40px;'>\r\n"
							+ "			<p style='font-size: 24px;'>以下是您的验证码：</p>\r\n"
							+ "			<p style='font-size: 24px; color: chartreuse;'>" + code + "</p>\r\n"
							+ "			<p>，您好！</p>\r\n"
							+ "			<p>我们收到了来自您的超市订单管系统通行证的安全请求。请使用上面的验证码验证您的账号归属</p>\r\n"
							+ "			<p>请注意：该验证码将在10分钟后过期，请尽快验证！</p>\r\n" + "		</div>\r\n",
					true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		mailSender.send(msg);
		System.out.println("邮件发送完毕");
	}

	/**
	 * 发送带有附件的email
	 * 
	 * @throws MessagingException
	 */
	@Test
	public void sendEmailWithAttachment() throws MessagingException {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.qq.com");// 指定用来发送Email的邮件服务器主机名
		mailSender.setPort(25);// 默认端口，标准的SMTP端口
		mailSender.setUsername("839682910@qq.com");// 用户名
		mailSender.setPassword("nhebjjznqdfsbcjj");// 密码

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);// 构造消息helper，第二个参数表明这个消息是multipart类型的
		helper.setFrom("839682910@163.com");
		helper.setTo("1017969905@qq.com");
		helper.setSubject("Spring Email Test");
		helper.setText("这是一个带有附件的消息");
		// 使用Spring的FileSystemResource来加载fox.png
		FileSystemResource image = new FileSystemResource("D:\\fox.png");
		System.out.println(image.exists());
		helper.addAttachment("fox.png", image);// 添加附加，第一个参数为添加到Email中附件的名称，第二个人参数是图片资源
		mailSender.send(message);
		System.out.println("邮件发送完毕");
	}

}