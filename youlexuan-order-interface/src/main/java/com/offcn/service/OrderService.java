package com.offcn.service;

import java.util.List;

import com.offcn.pojo.TbOrder;
import com.offcn.pojo.TbPayLog;

public interface OrderService {

	void addOrder(TbOrder tbOrder);
	
	TbPayLog findPayLogFromReids(String userId);
	
	void updatePayLogStatus(String outTradeNo,String tradeState);
	
	List<TbOrder> getTbOrderByUserId(String userId);
	
	void updateStatus(String orderId,String status);
}
