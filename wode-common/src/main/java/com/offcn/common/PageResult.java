package com.offcn.common;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {

	private Long total;// 总条目数
	private List rows;// 每页的条目

	public PageResult(Long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}
