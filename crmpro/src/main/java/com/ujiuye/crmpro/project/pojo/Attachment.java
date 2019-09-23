package com.ujiuye.crmpro.project.pojo;

import java.util.Date;

public class Attachment {
    private Integer id;

    private Integer proFk;

    private String attname;

    private String attdis;

    private String remark;

    private String path;

    private Date addtime;

    private Date updatetime;

    private Integer type;

    private Integer tag;
    
    private Project project;
    
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProFk() {
        return proFk;
    }

    public void setProFk(Integer proFk) {
        this.proFk = proFk;
    }

    public String getAttname() {
        return attname;
    }

    public void setAttname(String attname) {
        this.attname = attname == null ? null : attname.trim();
    }

    public String getAttdis() {
        return attdis;
    }

    public void setAttdis(String attdis) {
        this.attdis = attdis == null ? null : attdis.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }
}