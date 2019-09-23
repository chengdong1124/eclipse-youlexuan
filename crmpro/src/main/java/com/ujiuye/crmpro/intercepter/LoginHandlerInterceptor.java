package com.ujiuye.crmpro.intercepter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//������
public class LoginHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//�ж��Ƿ�Ϊ��¼ҳ��
		String uri = request.getRequestURI();
		
		if(uri.indexOf("login")>0 ||uri.indexOf("css")>0||uri.indexOf("img")>0||uri.indexOf("fonts")>0||uri.indexOf("js")>0||uri.indexOf("ueditor")>0) {
			return true;//���ڵ�¼ҳ��
		}
		//�ж��Ƿ��¼
		Object object = request.getSession().getAttribute("LOGIN");
		if(object!=null) {//�Ѿ���¼��
			return true;//������������
		}
		//���û�е�¼��תȥ��¼ҳ��
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