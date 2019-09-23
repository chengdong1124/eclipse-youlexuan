package com.ujiuye.crmpro.message.pojo;

import java.util.Date;

import com.ujiuye.crmpro.employee.pojo.Employee;

public class Message {
    private Integer msgid;

    private Integer send;

    private Integer receive;

    private String title;

    private String content;

    private Integer status;

    private String path;

    private Date time;

    private Integer type;
    
    private Employee employee;
    
	public Message(Integer msgid, Integer status) {
		this.msgid = msgid;
		this.status = status;
	}

	public Message() {
		super();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public Integer getSend() {
        return send;
    }

    public void setSend(Integer send) {
        this.send = send;
    }

    public Integer getReceive() {
        return receive;
    }

    public void setReceive(Integer receive) {
        this.receive = receive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}