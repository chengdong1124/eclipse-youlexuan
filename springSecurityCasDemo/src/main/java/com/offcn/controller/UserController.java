package com.offcn.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/user")
	public String getUserName() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return name;
		
	}
}
