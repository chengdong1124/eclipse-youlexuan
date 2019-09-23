package com.ujiuye.crmpro.employee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
		
	@RequestMapping("/listByPFK")
	@ResponseBody
	public String listByPFK(int p_fk) {
		List<Employee> list = employeeService.listByPFK(p_fk);
		return JSON.toJSONString(list);
		
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(Model model,Employee employee,String code,HttpSession session) {
		String sysCode =String.valueOf(session.getAttribute("CODE"));
		if(!sysCode.equalsIgnoreCase(code)) {
			return "error";
		}
		Employee sysemployee = employeeService.login(employee);
		if(sysemployee!=null) {     //单个对象
			//model.addAttribute("LOGIN", sysemployee);
			session.setAttribute("LOGIN", sysemployee);
			return "true";
		}
		return "false";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("LOGIN");
		return "login";
	}
		
	
	@RequestMapping("/listall")
	@ResponseBody
	public String listAll() {
		List<Employee> list = employeeService.list();
		return JSON.toJSONString(list);
		
	}
}
















