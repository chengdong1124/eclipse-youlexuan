package com.ujiuye.crmpro.project.pojo;

import java.util.Date;
import java.util.List;

import com.ujiuye.crmpro.customer.pojo.Customer;
import com.ujiuye.crmpro.employee.pojo.Employee;

public class Project {
    private Integer pid;

    private String pname;

    private Integer comname;

    private String companyperson;

    private Integer empcount;

    private Date starttime;

    private Date buildtime;

    private Integer cost;

    private String level;

    private Date endtime;

    private String remark;

    private Integer empFk;
    
    private Customer customer;
    
    private Employee employee;
    
    private List<Integer> ids;
    
    
      
	/**
	 * @return the ids
	 */
	public List<Integer> getIds() {
		return ids;
	}

	/**
	 * @param ids the ids to set
	 */
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Integer getComname() {
        return comname;
    }

    public void setComname(Integer comname) {
        this.comname = comname;
    }

    public String getCompanyperson() {
        return companyperson;
    }

    public void setCompanyperson(String companyperson) {
        this.companyperson = companyperson == null ? null : companyperson.trim();
    }

    public Integer getEmpcount() {
        return empcount;
    }

    public void setEmpcount(Integer empcount) {
        this.empcount = empcount;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }
}