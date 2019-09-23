package com.ujiuye.crmpro.task.pojo;

import java.util.Date;
import java.util.List;

import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.project.pojo.Function;

public class Task {
    private Integer id;

    private Date starttime;

    private Date endtime;

    private String level;

    private String remark;

    private Integer funFk;

    private Integer empFk2;

    private Integer empFk;

    private String tasktitle;

    private Integer status;
    
    private List<Integer> ids;
    
    private Employee executor; //执行者
    
    private Employee distributor; //分配者
    
    private Function function;

  
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Employee getExecutor() {
		return executor;
	}

	public void setExecutor(Employee executor) {
		this.executor = executor;
	}


	public Employee getDistributor() {
		return distributor;
	}


	public void setDistributor(Employee distributor) {
		this.distributor = distributor;
	}


	public Function getFunction() {
		return function;
	}

	
	public void setFunction(Function function) {
		this.function = function;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getFunFk() {
        return funFk;
    }

    public void setFunFk(Integer funFk) {
        this.funFk = funFk;
    }

    public Integer getEmpFk2() {
        return empFk2;
    }

    public void setEmpFk2(Integer empFk2) {
        this.empFk2 = empFk2;
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    public String getTasktitle() {
        return tasktitle;
    }

    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle == null ? null : tasktitle.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}