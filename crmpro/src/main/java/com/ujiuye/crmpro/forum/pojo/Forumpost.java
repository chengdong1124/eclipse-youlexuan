package com.ujiuye.crmpro.forum.pojo;

import java.util.Date;

import com.ujiuye.crmpro.employee.pojo.Employee;

public class Forumpost {
    private Integer forumid;

    private String forumtitle;

    private String forumcontent;

    private Integer empFk3;

    private Date createtime;

    private Integer status;

    private Integer forumsortFk;

    private Integer commentCount;

    private Integer click;

    private String label;
    
    private Employee employee;
    
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }

    public String getForumtitle() {
        return forumtitle;
    }

    public void setForumtitle(String forumtitle) {
        this.forumtitle = forumtitle == null ? null : forumtitle.trim();
    }

    public String getForumcontent() {
        return forumcontent;
    }

    public void setForumcontent(String forumcontent) {
        this.forumcontent = forumcontent == null ? null : forumcontent.trim();
    }

    public Integer getEmpFk3() {
        return empFk3;
    }

    public void setEmpFk3(Integer empFk3) {
        this.empFk3 = empFk3;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getForumsortFk() {
        return forumsortFk;
    }

    public void setForumsortFk(Integer forumsortFk) {
        this.forumsortFk = forumsortFk;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }
}