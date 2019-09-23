package com.offcn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offcn.common.IdWorker;
import com.offcn.common.Result;
import com.offcn.pojo.TbOrder;
import com.offcn.pojo.TbPayLog;
import com.offcn.service.OrderService;
import com.offcn.service.PayService;

@RestController
@RequestMapping("/pay")
public class PayController {

	@Autowired
	private PayService payService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/create")
	public Map createErWeiCode() {

		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		
		TbPayLog tbPayLog = orderService.findPayLogFromReids(name);
		if(tbPayLog != null) {
			Map map = payService.createErWeiCode(tbPayLog.getOutTradeNo()+"", tbPayLog.getTotalFee()+"");
			return map;
		}
		return new HashMap();

	}

	@RequestMapping("/query")
	public Result queryPayStatus(String orderId) throws InterruptedException {
		Result result = null;
		int i = 0;
		while (true) {
			Map map = payService.queryPayStatus(orderId);
			if (map.get("trade_status") != null && map.get("trade_status").equals("TRADE_CLOSED")) {
				orderService.updateStatus(orderId, "3");
				orderService.updatePayLogStatus(orderId, "2");
				result = new Result(false, "未付款交易超时关闭，或支付完成后全额退款");
				break;
			}
			if(map.get("trade_status") != null && map.get("trade_status").equals("TRADE_SUCCESS")) {
				result = new Result(true, "交易支付成功");
				orderService.updateStatus(orderId, "2");
				orderService.updatePayLogStatus(orderId, "2");
				break;
			}
			Thread.sleep(2000);
			
			i += 1;
			if(i >= 30) {
				result = new Result(false,"过期不候");
			}
			
		}

		return result;

	}

}












