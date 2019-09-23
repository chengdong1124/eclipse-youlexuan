package com.ujiuye.crmpro.project.controller;

import java.util.Date;
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
import com.ujiuye.crmpro.project.pojo.Project;
import com.ujiuye.crmpro.project.service.AnalysisService;
import com.ujiuye.crmpro.project.service.FunctionService;
import com.ujiuye.crmpro.project.service.ModuleService;
import com.ujiuye.crmpro.project.service.ProjectService;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {
	@Autowired
	private AnalysisService analysisService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private FunctionService functionService;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key) {

		PageHelper.startPage(pageNum, 5);
		List<Analysis> list = analysisService.list(type, key);
		PageInfo<Analysis> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("key", key);

		return "list-analysis";

	}

	@RequestMapping("/getbyid")
	@ResponseBody
	public String getById(int id) {
		Analysis analysis = analysisService.getById(id);
		return JSON.toJSONString(analysis);

	}

	@RequestMapping("/save")
	@ResponseBody
	public String save(Analysis analysis) {
		Project project = projectService.getById(analysis.getId());
		String pname = project.getPname();
		analysis.setAddtime(new Date());
		analysis.setUpdatetime(new Date());
		analysis.setProname(pname);
		if (analysisService.save(analysis)) {
			return "true";
		}
		return "false";
	}

	@RequestMapping("/removeall")
	@ResponseBody
	public String removeAll(Analysis analysis) {
		List<Integer> ids = analysis.getIds();
		String str = "";
		for (int i = ids.size() - 1; i >= 0; i--) {
			Integer id = ids.get(i);
			if (moduleService.listByAnalysisFk(id).size() > 0 || functionService.listByAnalysisName(id).size() > 0) {
				str += ",id=" + id;
				ids.remove(i);
			}
		}
		if (str.length() == 0) {
			if (projectService.removeAll(ids)) {
				return "true";
			} else {
				return "false";
			}

		}
		if (ids.size() > 0) {
			if (projectService.removeAll(ids)) {
				return str.substring(str.indexOf(1));
			} else {
				return "false";
			}

		} else {
			return "false";
		}
	}

	@RequestMapping("/show")
	public String show(Model model, int id) {
		Analysis analysis = analysisService.getById(id);
		model.addAttribute("analysis", analysis);
		return "show-analysis";

	}

	@RequestMapping("/removeone")
	@ResponseBody
	public String removeOne(int id) {
		String str="";
		if (moduleService.listByAnalysisFk(id).size() > 0 || functionService.listByAnalysisName(id).size() > 0) {
			str=String.valueOf(id);
			return str;
		}
		if (analysisService.removOne(id)) {
			return "true";
		}
		return "false";
	}
	
	@RequestMapping("/toupdate")
	public String toupdate(Model model,int id) {
		Analysis analysis = analysisService.getById(id);
		model.addAttribute("analysis", analysis);
		return "update-analysis";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Analysis analysis) {
		Project project = projectService.getById(analysis.getId());
		String pname = project.getPname();
		analysis.setUpdatetime(new Date());
		analysis.setProname(pname);
		if(analysisService.update(analysis)) {
			return "true";
		}
		return "false";
	}
	
	
}

















