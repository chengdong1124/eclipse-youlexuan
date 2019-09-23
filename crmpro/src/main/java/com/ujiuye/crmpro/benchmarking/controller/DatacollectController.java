package com.ujiuye.crmpro.benchmarking.controller;

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
import com.ujiuye.crmpro.benchmarking.pojo.Datacollect;
import com.ujiuye.crmpro.benchmarking.pojo.Indexvalue;
import com.ujiuye.crmpro.benchmarking.service.DatacollectService;
import com.ujiuye.crmpro.benchmarking.service.IndexvalueService;
import com.ujiuye.crmpro.project.pojo.Analysis;

@Controller
@RequestMapping("/datacollect")
public class DatacollectController {
	
	@Autowired
	private DatacollectService datacollectService;
	@Autowired
	private IndexvalueService indexvalueService;
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key) {

		PageHelper.startPage(pageNum, 8);
		
		List<Datacollect> list = datacollectService.list(type, key);
		PageInfo<Datacollect> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("key", key);

		return "list-benchmarking";

	}
	@RequestMapping("/removeall")
	@ResponseBody
	public String removeAll(Datacollect datacollect) {
		List<Integer> ids = datacollect.getIds();
		String str="";//str.length=0
		for (int i=ids.size()-1;i>=0;i--) {
			Integer id = ids.get(i);
			List<Indexvalue> list = indexvalueService.getBydatacollectFk(id);
			if(list.size()>0) {
				ids.remove(i);
				str += ",id="+id;
			}
		}
		if(ids.size()==0) {
			return "false";
		}
		if(str.length()>0) {
			if(datacollectService.removeAll(ids)) {
				return str.substring(1);
			}
		}
		if(datacollectService.removeAll(ids)) {
			return "true";
		}
		return "false";
	}
	
	@RequestMapping("/listall")
	@ResponseBody
	public String listAll() {
		List<Datacollect> list = datacollectService.list(0,null);
		return JSON.toJSONString(list);
	}
	
	@RequestMapping("/show")
	public String show(Model model,int id) {
		Datacollect datacollect = datacollectService.getById(id);
		model.addAttribute("datacollect", datacollect);
		return "show-benchmarking";
	}
	
	@RequestMapping("/removeone")
	@ResponseBody
	public String removeOne(int id) {
		List<Indexvalue> list = indexvalueService.getBydatacollectFk(id);
		if(list.size()>0) {
			return "false";
		}
		if(datacollectService.removeOne(id)) {
			
			return "true";
		}
		return "false";
	}
	@RequestMapping("/save")
	@ResponseBody
	public String save(Datacollect datacollect) {
		if(datacollectService.save(datacollect)) {
			return "true";
		}
		return "false";
		
	}
	@RequestMapping("/toupdate")
	public String toUpdate(Model model,int id) {
		Datacollect datacollect = datacollectService.getById(id);
		model.addAttribute("datacollect", datacollect);
		return "update-datacollect";
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Datacollect datacollect) {
		if(datacollectService.update(datacollect)) {
			return "true";
		}
		
		return "false";
		
	}
	@RequestMapping("/getbyid")
	@ResponseBody
	public String getById(int id) {
		Datacollect datacollect = datacollectService.getById(id);
		return JSON.toJSONString(datacollect);
		
	}
	
}

















