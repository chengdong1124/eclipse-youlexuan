package com.ujiuye.crmpro.intercepter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//判断是否为登录页面
		String uri = request.getRequestURI();
		
		if(uri.indexOf("login")>0 ||uri.indexOf("css")>0||uri.indexOf("img")>0||uri.indexOf("fonts")>0||uri.indexOf("js")>0||uri.indexOf("ueditor")>0) {
			return true;//处于登录页面
		}
		//判断是否登录
		Object object = request.getSession().getAttribute("LOGIN");
		if(object!=null) {//已经登录，
			return true;//返回真代表放行
		}
		//如果没有登录跳转去登录页面
		response.sendRedirect("/crmpro/login.jsp");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}