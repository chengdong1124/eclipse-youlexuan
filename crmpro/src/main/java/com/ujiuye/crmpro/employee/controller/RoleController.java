package com.ujiuye.crmpro.employee.controller;

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
import com.ujiuye.crmpro.employee.pojo.Role;
import com.ujiuye.crmpro.employee.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum) {

		PageHelper.startPage(pageNum, 5);
		List<Role> list = roleService.list(type, key);
		PageInfo<Role> page = new PageInfo<>(list);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("type", type);
		model.addAttribute("key", key);
		return "list-role";

	}
	
	@RequestMapping("/removeall")
	@ResponseBody
	public String removeAll(Role role) {
		List<Integer> ids = role.getIds();
		if(roleService.removeAll(ids)){
			return "true";
		}
		return "false";
	}
	
	@RequestMapping("/toupdate")
	@ResponseBody
	public String toUpdate(int id) {
		Role role = roleService.getById(id);
		return JSON.toJSONString(role);
		
	}
	@RequestMapping("/update")
	@ResponseBody
	public String update(Role role) {
		if(roleService.update(role)) {
			return "true";
		}
		return "false";
		
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Role role) {
		if(roleService.save(role)) {
			return "true";
		}
		return "false";
	}

	@RequestMapping("/removeOne")
	@ResponseBody
	public String removeOne(int id) {
		if(roleService.removeOne(id)) {
			return "true";
		}
		return "false";
	}

	
}

	















