package com.offcn.service;

import java.util.List;

import com.offcn.common.Cart;

public interface CartService {

	//保存商品到购物车
	public List<Cart> addGoodsToCart(int num,long itemId,List<Cart> cartList);
	
	//从redis中查询购物车
	public List<Cart> findCartByRedis(String loginName);
	
	//添加购物车到redis
	void saveCartToRedis(String loginName,List<Cart> cartList);

	//合并购物车
	List<Cart> cartTogether(List<Cart> cartList1,List<Cart> cartList2);
}
