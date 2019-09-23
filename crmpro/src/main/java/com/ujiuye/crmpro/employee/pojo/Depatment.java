package com.ujiuye.crmpro.employee.pojo;

import java.util.List;

public class Depatment {
    private Integer deptno;

    private String dname;

    private String dlocation;
    
    private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getDlocation() {
        return dlocation;
    }

    public void setDlocation(String dlocation) {
        this.dlocation = dlocation == null ? null : dlocation.trim();
    }
}