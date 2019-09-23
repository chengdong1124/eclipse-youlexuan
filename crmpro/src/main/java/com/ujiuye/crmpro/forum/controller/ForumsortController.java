package com.ujiuye.crmpro.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ujiuye.crmpro.forum.pojo.Forumsort;
import com.ujiuye.crmpro.forum.service.ForumsortService;

@Controller
@RequestMapping("/forumsort")
public class ForumsortController {

	@Autowired
	private ForumsortService forumsortService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Forumsort> list = forumsortService.list();
		int mainSum=0;
		int subSum=0;
		for (Forumsort forumsort : list) {
			if(forumsort.getType()==0) {
				mainSum += forumsort.getCount();
			}else {
				subSum += forumsort.getCount();
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("mainSum", mainSum);
		model.addAttribute("subSum", subSum);
		return "list-forum-main";
		
	} 
	@RequestMapping("/listall")
	@ResponseBody
	public String listAll() {
		List<Forumsort> list = forumsortService.list();
		return JSON.toJSONString(list);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
