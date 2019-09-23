package com.offcn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.offcn.common.Cart;
import com.offcn.common.CookieUtil;
import com.offcn.common.Result;
import com.offcn.pojo.TbAddress;
import com.offcn.service.CartService;
import com.offcn.service.UserService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private HttpServletRequest httpServletRequest;
	@Autowired
	private HttpServletResponse httpServletResponse;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/findAllCart")
	public List<Cart> findAllCartList() {
		String loginName = SecurityContextHolder.getContext().getAuthentication().getName();

		String cartString = CookieUtil.getCookieValue(httpServletRequest, "cartList", "UTF-8");
		if (cartString == null || cartString.equals("")) { 
			// 你敢信就是因为cartString.equals("")在前面就报空指针
			// 把cartString == null放前面就不空指针
			cartString = "[]";
		}
		List<Cart> cookieCartList = JSON.parseArray(cartString, Cart.class);
		
		if (loginName.equals("anonymousUser")) {// 说明没有登录，匿名用户
			
			return cookieCartList;
			
		} else {
			
			List<Cart> redisCartList = cartService.findCartByRedis(loginName);
			if (cookieCartList.size() > 0) {
				// 进行购物车合并
				redisCartList = cartService.cartTogether(redisCartList, cookieCartList);
				CookieUtil.deleteCookie(httpServletRequest, httpServletResponse, "cartList");
				cartService.saveCartToRedis(loginName, redisCartList);
			}
			return redisCartList;
		}
	}

	@RequestMapping("/addCartToCookie")
	@CrossOrigin(origins="http://localhost:8088",allowCredentials="true") //后面的true可以不写
	public Result addGoodsToCart(long itemId, int num) {
		String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Cart> cartList = findAllCartList();
		cartList = cartService.addGoodsToCart(num, itemId, cartList);
		try {
			if (loginName.equals("anonymousUser")) {
				
				// 如果不登录的时候先把购物车的信息保存在cookie,如果登录的话需要把购物车信息保存到redis中
				CookieUtil.setCookie(httpServletRequest, httpServletResponse, "cartList",
						JSON.toJSONString(cartList),3600, "UTF-8");
				
				return new Result(true, "保存信息到cookie成功");
				
			} else {
				cartService.saveCartToRedis(loginName, cartList);
				return new Result(true, "保存信息到redis成功");
			}
		} catch (Exception e) {
			return new Result(false, "保存信息失败");
		}
	}
	
	@RequestMapping("/findAddressByUserId")
	public List<TbAddress> findAddressByUserId(){
		String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<TbAddress> addressList = userService.findAddressByUserName(loginName);
		return addressList;
		
	} 

}
























