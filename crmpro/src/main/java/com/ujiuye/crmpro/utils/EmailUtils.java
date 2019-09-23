package com.ujiuye.crmpro.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.ujiuye.crmpro.message.pojo.Email;

public class EmailUtils {

	public static boolean sent(Email email) {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.qq.com");// 指定用来发送Email的邮件服务器主机名
		mailSender.setPort(25);// 默认端口，标准的SMTP端口
		mailSender.setUsername("839682910@qq.com");// 用户名
		mailSender.setPassword("nhebjjznqdfsbcjj");// 密码/授权码
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(msg, true, "utf-8");
			helper.setFrom("839682910@qq.com");// 发件人
			helper.setTo(email.getSendto());// 收件人
			helper.setSubject(email.getTitle());
			// 第二个参数true，表示text的内容为html，然后注意<img/>标签，src='cid:file'，'cid'是contentId的缩写，'file'是一个标记，需要在后面的代码中调用MimeMessageHelper的addInline方法替代成文件
			helper.setText(email.getContent(), true);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		mailSender.send(msg);
		System.out.println("邮件发送完毕");
		return true;

	}

}
















