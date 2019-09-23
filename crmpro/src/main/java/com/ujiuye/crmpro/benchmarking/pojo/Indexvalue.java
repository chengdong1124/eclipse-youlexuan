package com.ujiuye.crmpro.benchmarking.pojo;

import java.util.Date;
import java.util.List;

import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.employee.service.EmployeeService;

public class Indexvalue {
    private Integer id;

    private Double turnover;

    private String business;

    private Integer datacollectFk;

    private String remark;

    private String file;

    private Integer empFk5;

    private Date starttime;

    private Date endtime;

    private Date updatetime;
    
    private Datacollect datacollect;
    
    private Employee employee;
    
    private List<Integer> ids;
    
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Datacollect getDatacollect() {
		return datacollect;
	}


	public void setDatacollect(Datacollect datacollect) {
		this.datacollect = datacollect;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public Integer getDatacollectFk() {
        return datacollectFk;
    }

    public void setDatacollectFk(Integer datacollectFk) {
        this.datacollectFk = datacollectFk;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public Integer getEmpFk5() {
        return empFk5;
    }

    public void setEmpFk5(Integer empFk5) {
        this.empFk5 = empFk5;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}