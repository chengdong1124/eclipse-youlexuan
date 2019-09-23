package com.offcn.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.offcn.common.Cart;
import com.offcn.dao.TbItemMapper;
import com.offcn.pojo.TbItem;
import com.offcn.pojo.TbOrderItem;
import com.offcn.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public List<Cart> addGoodsToCart(int num, long itemId, List<Cart> cartList) {
		//根据商品的Id,TbItem的Id,查询商品
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		if(tbItem == null) {
			throw new RuntimeException("商品不存在");
		}
		if(!tbItem.getStatus().equals("2")) {
			throw new RuntimeException("商品不可使用");
		}
		//如果商品存在就根据商品的Id查询商家的Id
		String sellerId = tbItem.getSellerId();
		//根据商家 的Id判断商家是否有购物车
		Cart cart = searchCartBySellerId(sellerId,cartList);
		if(cart == null) { //该商家的购物车不存在，需要给该商家创建一个空的购物车
			cart = new Cart();
			cart.setSellId(sellerId);
			cart.setName(sellerId);
			List orderItemList  = new ArrayList();
			TbOrderItem tbOrderItem = createTbOrderItem(tbItem,num);
			orderItemList.add(tbOrderItem);
			cart.setOrderItemList(orderItemList);
			cartList.add(cart); 
		}else {
			TbOrderItem tbOrderItem = searchTbOrderItemByItemId(itemId,cart.getOrderItemList());
			if(tbOrderItem == null) {
				TbOrderItem createTbOrderItem = createTbOrderItem(tbItem,num);
				List<TbOrderItem> orderItemList = cart.getOrderItemList();
				orderItemList.add(createTbOrderItem);
			}else {
				tbOrderItem.setNum(tbOrderItem.getNum()+num);
				tbOrderItem.setTotalFee(new BigDecimal(tbOrderItem.getPrice().doubleValue() * tbOrderItem.getNum()));
				if(tbOrderItem.getNum() <= 0) {
					List<TbOrderItem> orderItemList = cart.getOrderItemList();
					orderItemList.remove(tbOrderItem);
				}
				if(cart.getOrderItemList().size() == 0) {
					cartList.remove(cart);
				}
			}
		}
		return cartList;
	}
	
	//判断商家的Id的购物车是否存在
	public Cart searchCartBySellerId(String sellerId,List<Cart> cartList) {
		for (Cart cart : cartList) {
			String sellId = cart.getSellId();
			if(sellId.equals(sellerId)) {
				return cart;
			}
		}
		return null;
		
	}
	
	public TbOrderItem createTbOrderItem(TbItem tbItem,int num) {
		if(num <= 0) {
			throw new RuntimeException("数量非法");
		}
		TbOrderItem tbOrderItem = new TbOrderItem();
		tbOrderItem.setNum(num);
		tbOrderItem.setGoodsId(tbItem.getGoodsId());
		tbOrderItem.setSellerId(tbItem.getSellerId());
		tbOrderItem.setPrice(tbItem.getPrice());
		tbOrderItem.setPicPath(tbItem.getImage());
		tbOrderItem.setTotalFee(new BigDecimal(tbItem.getPrice().doubleValue()*num));
		tbOrderItem.setItemId(tbItem.getId());
		tbOrderItem.setTitle(tbItem.getTitle());
		return tbOrderItem;
	}
	
	public TbOrderItem searchTbOrderItemByItemId(long itemId,List<TbOrderItem> orderItemList) {
		for (TbOrderItem tbOrderItem : orderItemList) {
			Long itemId2 = tbOrderItem.getItemId();
			if(itemId2.equals(itemId)) {
				return tbOrderItem;
			}
		}
		return null;
	}

	
	@Override
	public List<Cart> findCartByRedis(String loginName) {
		List<Cart> cartList = (List<Cart>)redisTemplate.boundHashOps("cartList").get(loginName);
		if(cartList == null) {
			cartList  = new ArrayList();
		}
		return cartList;
	}

	@Override
	public void saveCartToRedis(String loginName, List<Cart> cartList) {
		
		redisTemplate.boundHashOps("cartList").put(loginName,cartList);
		
	}

	//cartList1是redis
	//cartList2是cookie
	@Override
	public List<Cart> cartTogether(List<Cart> cartList1, List<Cart> cartList2) {
		for (Cart cart2 : cartList2) {
			for (TbOrderItem tbOrderItem : cart2.getOrderItemList()) {
				cartList1 = addGoodsToCart(tbOrderItem.getNum(),tbOrderItem.getItemId(),cartList1);
			}
		}
		
		return cartList1;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
