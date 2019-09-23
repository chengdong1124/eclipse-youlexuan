package com.offcn.service;

import java.util.Map;

public interface PayService {

	//生成二维码
	public Map createErWeiCode(String orderId,String totalFee);
	
	//支付状态查询
	Map queryPayStatus(String orderId);
}
