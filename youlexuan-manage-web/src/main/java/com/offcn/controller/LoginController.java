package com.offcn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	
	@RequestMapping("/name")
	public Map getLoginName() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		Map map = new HashMap();
		map.put("loginName", userName);
		return map;
	}
}
