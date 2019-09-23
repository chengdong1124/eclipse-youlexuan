package com.ujiuye.crmpro.message.pojo;

import java.io.Serializable;

public class Email implements Serializable{

	private String sendto;//�ռ���
	private String title;//����
	private String content;//����
	private String time;//��ʱ���͵�ʱ��
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Email(String sendto, String title, String content) {
		this.sendto = sendto;
		this.title = title;
		this.content = content;
	}
	
	public Email() {
		super();
		
	}
	/**
	 * @return the sendto
	 */
	public String getSendto() {
		return sendto;
	}
	/**
	 * @param sendto the sendto to set
	 */
	public void setSendto(String sendto) {
		this.sendto = sendto;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
