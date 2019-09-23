package com.ujiuye.crmpro.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ujiuye.crmpro.employee.pojo.Sources;
import com.ujiuye.crmpro.employee.service.SourcesService;

@Controller
@RequestMapping("/sources")
public class SourcesController {
	
	@Autowired
	private SourcesService sourcesService;
	
	@RequestMapping(value="/list",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String list() {
		List<Sources> list = sourcesService.list();
		return JSON.toJSONString(list);
	}
	
	@RequestMapping(value="/listztree",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String listZtree() {
		List<Sources> list = sourcesService.listZtree();
		return JSON.toJSONString(list);
	}
	
	@RequestMapping(value="/remove")
	@ResponseBody
	public String remove(int id) {
		
		if(sourcesService.remove(id)) {
			return "true";
		}
		return "false";
	}

	
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(Sources sources) {
		
		if(sourcesService.save(sources)) {
			return "true";
		}
		return "false";
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	public String update(Sources sources) {
		
		if(sourcesService.update(sources)) {
			return "true";
		}
		return "false";
	}
	
	@RequestMapping(value="get",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String get(int id) {
		Sources sources = sourcesService.getById(id);
		return JSON.toJSONString(sources);
	}

}



















