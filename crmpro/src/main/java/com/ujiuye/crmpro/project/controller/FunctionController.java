package com.ujiuye.crmpro.project.controller;

import java.util.ArrayList;
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
import com.ujiuye.crmpro.project.pojo.Function;
import com.ujiuye.crmpro.project.pojo.Project;
import com.ujiuye.crmpro.project.service.FunctionService;
import com.ujiuye.crmpro.task.pojo.Task;
import com.ujiuye.crmpro.task.service.TaskService;

@Controller
@RequestMapping("/function")
public class FunctionController {
	
	@Autowired
	private FunctionService functionService;
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key) {
		
		PageHelper.startPage(pageNum, 5);

		List<Function> list = functionService.list(type, key);

		PageInfo<Function> page = new PageInfo<>(list);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("type", type);
		model.addAttribute("key", key);
		return "list-function";

	}
	
	//添加
	@RequestMapping("/save")
	@ResponseBody
	public String save(Function function) {
		boolean save = functionService.save(function);
		if(save) {
			return "true";
		}
		return "false";
	}
	
	@RequestMapping("/remove")
	@ResponseBody
	public String remove(int id) {
		List list = taskService.getByfunFk(id);
		if(list.size()>0) {
			return String.valueOf(id);
		}else {
			if(functionService.remove(id)) {
				return "true";
			}	
			return "false";	
		}
		
	}
	
	//未完待续，写完task表再来
	@RequestMapping("/removeall")
	@ResponseBody
	public String removeAll(Function function) {
		List<Integer> ids = function.getIds();
		String str="";
		for (int i=0;i<ids.size();i++) {
			Integer integer = ids.get(i);
			List list = taskService.getByfunFk(integer);
			if(list.size()>0) {
				str =",id="+integer;
				Integer remove = ids.remove(i);
				i--;              //还可以从后往前循环
			}
		}
		
		if(str.length()==0) {
			if(functionService.removeAll(ids)) {
				return "true";
			}else {
				return "false";
			}//空的不能删
			
		}
		if(ids.size()>0) {
			if(functionService.removeAll(ids)) {
				str.substring(str.indexOf(1));
				return str;
			}
		}
		return "false";
	}
	
	@RequestMapping("/show")
	public String show(Model model,int id) {
		Function function = functionService.getById(id);
		model.addAttribute("function", function);
		return "show-function";	
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Function function) {
		if(functionService.update(function)){
			return "true";	
		}
		return "false";	
	}
	
	@RequestMapping("/toupdate")
	public String toUpdate(Model model,int id) {
		Function function = functionService.toUpdate(id);
		model.addAttribute("function", function);
		return "update-function";
	}
	
	@RequestMapping("/listbyfk")
	@ResponseBody
	public String listByModule(int fk) {
		
		List<Function> list = functionService.listByModleId(fk);
		
		return JSON.toJSONString(list);
		
	}
	
}












