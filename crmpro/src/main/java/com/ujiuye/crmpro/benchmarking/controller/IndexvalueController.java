package com.ujiuye.crmpro.benchmarking.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.crmpro.benchmarking.pojo.Indexvalue;
import com.ujiuye.crmpro.benchmarking.service.IndexvalueService;
import com.ujiuye.crmpro.employee.pojo.Archives;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.utils.FileUtils;

@Controller
@RequestMapping("/indexvalue")
public class IndexvalueController {

	@Autowired
	private IndexvalueService indexvalueService;
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key) {
		PageHelper.startPage(pageNum, 10);
		List<Indexvalue> list = indexvalueService.list(type, key);
		PageInfo<Indexvalue> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("key", key);
		return "list-indexvalue";
	}
	
	@RequestMapping("/removeall")
	@ResponseBody
	public String removeAll(Indexvalue indexvalue) {
		List<Integer> ids = indexvalue.getIds();
		if(indexvalueService.removeAll(ids)) {
			return "true";
		}
		return "null";
		
	}
	
	@RequestMapping("/show")
	public String show(Model model,int id) {
		Indexvalue indexvalue = indexvalueService.getById(id);
		model.addAttribute("indexvalue", indexvalue);
		return "show-indexvalue";
		
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(MultipartFile[] myfiles,Indexvalue indexvalue,HttpSession session) {
		List<File> upload = FileUtils.upload(myfiles, null);
		if(upload.size()>0) {
			File file = upload.get(0);
			indexvalue.setFile(file.getName());
		}
		Employee employee = (Employee)session.getAttribute("LOGIN");
		indexvalue.setEmpFk5(employee.getEid());
		if(indexvalueService.save(indexvalue)) {
			return "true";
		}
		return "false";
	}
	
	
	@RequestMapping("/toupdate")
	public String toUpdate(Model model,int id) {
		Indexvalue indexvalue = indexvalueService.getById(id);
		model.addAttribute("indexvalue", indexvalue);
		return "update-indexvalue";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(MultipartFile[] myfiles,Indexvalue indexvalue,HttpSession session) {
		List<File> upload = FileUtils.upload(myfiles, null);
		if(upload.size()>0) {
			File file = upload.get(0);
			indexvalue.setFile(file.getName());
		}
		Employee employee = (Employee)session.getAttribute("LOGIN");
		indexvalue.setEmpFk5(employee.getEid());
		boolean update = indexvalueService.update(indexvalue);
		if(indexvalueService.update(indexvalue)) {
			return "true";
		}
		return "false";
		
	}
}















