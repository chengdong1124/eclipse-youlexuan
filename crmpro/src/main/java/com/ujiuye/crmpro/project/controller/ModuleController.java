package com.ujiuye.crmpro.project.controller;

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
import com.ujiuye.crmpro.project.pojo.Analysis;
import com.ujiuye.crmpro.project.pojo.Function;
import com.ujiuye.crmpro.project.pojo.Module;
import com.ujiuye.crmpro.project.service.FunctionService;
import com.ujiuye.crmpro.project.service.ModuleService;

@Controller
@RequestMapping("/module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private FunctionService functionService;
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key) {

		PageHelper.startPage(pageNum, 5);
		List<Module> list = moduleService.list(type, key);
		PageInfo<Module> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("key", key);
		return "list-module";

	}
	
	
	@RequestMapping("/listByAnalysisFk")
	@ResponseBody
	public String listByAnalysisFk(int analysis_fk) {
		List<Module> list = moduleService.listByAnalysisFk(analysis_fk);
		return JSON.toJSONString(list);
		
	}
	@RequestMapping("/show")
	public String getById(Model model,int id) {
		Module module = moduleService.getById(id);
		model.addAttribute("module", module);
		return "show-module";

		
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Module module) {
		if(moduleService.save(module)) {
			return "true";
		}
		return "false";
		
	}
	
	@ResponseBody
	@RequestMapping("/removeall")
	public String removeAll(Module module) {
		
		List<Integer> ids = module.getIds();
		String str="";//¿Õ×Ö·û´®³¤¶ÈÎª0
		for(int i=ids.size()-1;i>=0;i--) {
			Integer id = ids.get(i);
			if(functionService.listByModleId(id).size()>0) {
				ids.remove(i);
				str += ",id="+ id;
			}
		}
		if(str.length()==0) {
			if(moduleService.removeAll(ids)) {
				return "true";
			}else {
				return "false";
			}
		}
		if(ids.size()>0) {
			if(moduleService.removeAll(ids)) {
				return str.substring(str.indexOf(1));
			}else {
				return "false";
			}
		}
		return "false";
	}
	
	@RequestMapping("/toupdate")
	public String toUpdate(Model model,int id) {
		Module module = moduleService.getById(id);
		model.addAttribute("module", module);
		return "update-module";
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Module module) {
		if(moduleService.update(module)) {
			return "true";
		}
		return "false";
		
	}
	@RequestMapping("/removeone")
	@ResponseBody
	public String removeOne(int id) {
		List<Function> listByModleId = functionService.listByModleId(id);
		if(listByModleId.size()>0) {
			return "false";
		}
		if(moduleService.removeOne(id)) {
			
			return "true";
		}
		return "false";
		
	}
	
}













