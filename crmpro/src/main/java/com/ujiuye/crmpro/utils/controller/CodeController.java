package com.ujiuye.crmpro.utils.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ujiuye.crmpro.utils.VerificationCode;

@Controller
public class CodeController {

	@RequestMapping("logincode.jpg")
	public void createCode(HttpServletRequest request, HttpServletResponse response) {
		VerificationCode.getVerificationCode(request, response);
	} 

}
