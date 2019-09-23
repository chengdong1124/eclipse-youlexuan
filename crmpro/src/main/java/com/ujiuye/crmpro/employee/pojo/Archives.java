package com.ujiuye.crmpro.employee.pojo;

import java.util.Date;
import java.util.List;

public class Archives {
    private String num;

    private String telephone;

    private String school;

    private String major;

    private String contact;

    private Date graudatetime;

    private String policstatus;

    private String nation;

    private String eductaion;

    private String email;

    private Integer empFk;

    private String remark;

    private Date hiredate;
    
    private Employee employee;
    
    private List<String> ids;
    
	public List<String> getIds() {
		return ids;
	}
	
	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public Archives() {
		super();
	}

	public Archives(String num, String telephone, String school, String major, String contact, Date graudatetime,
			String policstatus, String nation, String eductaion, String email, Integer empFk, String remark,
			Date hiredate) {
		this.num = num;
		this.telephone = telephone;
		this.school = school;
		this.major = major;
		this.contact = contact;
		this.graudatetime = graudatetime;
		this.policstatus = policstatus;
		this.nation = nation;
		this.eductaion = eductaion;
		this.email = email;
		this.empFk = empFk;
		this.remark = remark;
		this.hiredate = hiredate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public Date getGraudatetime() {
        return graudatetime;
    }

    public void setGraudatetime(Date graudatetime) {
        this.graudatetime = graudatetime;
    }

    public String getPolicstatus() {
        return policstatus;
    }

    public void setPolicstatus(String policstatus) {
        this.policstatus = policstatus == null ? null : policstatus.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getEductaion() {
        return eductaion;
    }

    public void setEductaion(String eductaion) {
        this.eductaion = eductaion == null ? null : eductaion.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}