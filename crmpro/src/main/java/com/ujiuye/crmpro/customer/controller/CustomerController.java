package com.ujiuye.crmpro.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.crmpro.customer.pojo.Customer;
import com.ujiuye.crmpro.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String list(Model model,
			@RequestParam(value="pageNum",required=false,defaultValue="1" ) int pageNum,
			@RequestParam(value="status",required=false,defaultValue="0" ) int status,
			@RequestParam(value="checkName",required=false,defaultValue="" ) String checkName) {
		
		PageHelper.startPage(pageNum,5);
		
		List<Customer> list = customerService.selectBy(checkName, status);
		
		PageInfo<Customer> page = new PageInfo<>(list);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("status", status);
		model.addAttribute("checkName", checkName);
		return "list-customer";
		
	}
	
	@RequestMapping("/listall")
	@ResponseBody
	public String listAll() {	
		List<Customer> list = customerService.list();
		
		return JSON.toJSONString(list);		
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Customer customer) {	
		if(customerService.save(customer)) {
			return "true";
		}else {
			return "false";
		}			
	}
	
	@RequestMapping("/show")
	public String show(Model model,int id) {
		Customer customer = customerService.get(id);
		model.addAttribute("customer", customer);	
		return "show-customer";
		
	}
	
	@RequestMapping("/toupdate")
	public String toupdate(Model model,int id) {
		Customer customer = customerService.get(id);
		model.addAttribute("customer", customer);	
		return "update-customer";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Customer customer) {
		if(customerService.update(customer)) {
			return "true";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/removeAll")
	@ResponseBody
	public String removeAll(Customer customer) {
		boolean removeAll = customerService.removeAll(customer.getIds());
		if(removeAll) {
			return "true";
		}else {
			return "false";
		}	
	}
	
	@RequestMapping("/removeOne")
	@ResponseBody
	public String removeOne(int id) {
		boolean removeOne = customerService.removeOne(id);
		if(removeOne) {
			return "true";
		}else {
			return "false";
		}	
	}
	
	
}

















