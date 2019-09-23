package com.offcn.common;

import java.io.Serializable;
import java.util.List;

import com.offcn.pojo.TbOrderItem;

public class Cart implements Serializable{
	
	private String sellId;
	private String name;
	private List<TbOrderItem> orderItemList;
	
	public String getSellId() {
		return sellId;
	}
	public void setSellId(String sellId) {
		this.sellId = sellId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TbOrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<TbOrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	@Override
	public String toString() {
		return "Cart [sellId=" + sellId + ", name=" + name + ", orderItemList=" + orderItemList + "]";
	}
	
	
	

}
