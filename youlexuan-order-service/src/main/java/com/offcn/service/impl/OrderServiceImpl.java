package com.offcn.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.offcn.common.Cart;
import com.offcn.common.IdWorker;
import com.offcn.dao.TbOrderItemMapper;
import com.offcn.dao.TbOrderMapper;
import com.offcn.dao.TbPayLogMapper;
import com.offcn.pojo.TbOrder;
import com.offcn.pojo.TbOrderExample;
import com.offcn.pojo.TbOrderExample.Criteria;
import com.offcn.pojo.TbOrderItem;
import com.offcn.pojo.TbPayLog;
import com.offcn.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private IdWorker idWorker;
	
	@Autowired
	private TbOrderItemMapper tbOrderItemMapper;
	
	@Autowired
	private TbOrderMapper tbOrderMapper;
	
	@Autowired
	private TbPayLogMapper tbPayLogMapper;
	
	@Override
	public void addOrder(TbOrder tbOrder) {
		//获取当前用户的购物车数据
		List<Cart> cartList = (List<Cart>) redisTemplate.boundHashOps("cartList").get(tbOrder.getUserId());
		
		List<String> orderList = new ArrayList();
		
		double totalFee = 0;
		for (Cart cart : cartList) {
			//生成订单id
			long id = idWorker.nextId();
			
			TbOrder order = new TbOrder();
			order.setOrderId(id);
			order.setUserId(tbOrder.getUserId());
			order.setPaymentType(tbOrder.getPaymentType());
			order.setStatus("1");//生成订单的时候默认都是未支付的
			order.setUpdateTime(new Date());
			order.setCreateTime(new Date());
			order.setReceiverMobile(tbOrder.getReceiverMobile());
			order.setReceiverAreaName(tbOrder.getReceiverAreaName());
			order.setReceiver(tbOrder.getReceiver());
			order.setSourceType(tbOrder.getSourceType());
			order.setSellerId(cart.getSellId());
			
			double money=0;
			for (TbOrderItem orderItem : cart.getOrderItemList()) {
				money += orderItem.getTotalFee().doubleValue();
				orderItem.setId(idWorker.nextId());
				orderItem.setOrderId(id);
				tbOrderItemMapper.insertSelective(orderItem);
				
			}
			
			orderList.add(id+"");
			totalFee += money;
			
			order.setPayment(new BigDecimal(money));
			tbOrderMapper.insertSelective(order);
			
		}
		//如果是支付宝支付才有日志，线下交易没有日志
		if(tbOrder.getPaymentType().equals("1")) {
			TbPayLog tbPayLog = new TbPayLog();
			IdWorker idWork = new IdWorker();
			tbPayLog.setOutTradeNo(idWork.nextId()+"");
			tbPayLog.setCreateTime(new Date());
			tbPayLog.setPayType("1");
			tbPayLog.setTradeState("1");	//1未支付，2支付成功，3支付失败
			tbPayLog.setTotalFee((long)totalFee);
			tbPayLog.setUserId(tbOrder.getUserId());
			tbPayLogMapper.insertSelective(tbPayLog);
			redisTemplate.boundHashOps("payLog").put(tbOrder.getUserId(), tbPayLog);
			TbPayLog payLog = (TbPayLog)redisTemplate.boundHashOps("payLog").get(tbOrder.getUserId());
		}
		
		//订单文成删除购物车信息
		redisTemplate.boundHashOps("cartList").delete(tbOrder.getUserId());
		
	}

	@Override
	public TbPayLog findPayLogFromReids(String userId) {
		TbPayLog tbPayLog = (TbPayLog)redisTemplate.boundHashOps("payLog").get(userId);
		return tbPayLog;
	}
	
	@Override
	public void updatePayLogStatus(String outTradeNo ,String tradeState) {
		
		TbPayLog tbPayLog = tbPayLogMapper.selectByPrimaryKey(outTradeNo);
		tbPayLog.setTradeState(tradeState);
		tbPayLog.setPayTime(new Date());
		tbPayLogMapper.updateByPrimaryKeySelective(tbPayLog);
	}

	
	
	@Override
	public List<TbOrder> getTbOrderByUserId(String userId) {
		TbOrderExample example = new TbOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<TbOrder> list = tbOrderMapper.selectByExample(example);
		return list;
	}

	@Override
	public void updateStatus(String orderId,String status) {
		
		TbOrder tbOrder = tbOrderMapper.selectByPrimaryKey(Long.valueOf(orderId));
		tbOrder.setStatus(status);
		tbOrder.setPaymentTime(new Date());
		tbOrderMapper.updateByPrimaryKeySelective(tbOrder);
	}

	
	
	
	
	
	

}





























