package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offcn.common.Result;
import com.offcn.pojo.TbOrder;
import com.offcn.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/add")
	public Result addOrder(@RequestBody TbOrder tbOrder) {
		try {
			String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
			
			tbOrder.setUserId(loginName);
			
			orderService.addOrder(tbOrder);

			return new Result(true,"生成订单成功");
		} catch (Exception e) {
			return new Result(true,"生成订单失败");
		}


	}
}















