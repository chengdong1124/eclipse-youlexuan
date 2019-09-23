package com.ujiuye.crmpro.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.crmpro.employee.pojo.Depatment;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.employee.service.DepatmentService;
import com.ujiuye.crmpro.employee.service.EmployeeService;
import com.ujiuye.crmpro.project.pojo.Analysis;

@Controller
@RequestMapping("/depatment")
public class DepatmentController {

	@Autowired
	private DepatmentService depatmentService;
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key) {

		PageHelper.startPage(pageNum, 5);
		List<Depatment> list = depatmentService.list(type, key);
		PageInfo<Depatment> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("key", key);

		return "list-dept";

	}

	@RequestMapping("/removeall")
	@ResponseBody
	public String removeAll(Depatment depatment) {
		List<Integer> ids = depatment.getIds();
		String str = "";
		for (int i = ids.size() - 1; i >= 0; i--) {
			Integer id = ids.get(i);
			List<Employee> bydfk = employeeService.getBydfk(id);
			if (bydfk.size() > 0) {
				ids.remove(i);
				str += ",id=" + id;
			}
		}
		if (ids.size() == 0) {
			return "fasle";
		}
		if (str.length() == 0) {
			if (depatmentService.removeAll(ids)) {
				return "true";
			}
		}
		if (depatmentService.removeAll(ids)) {
			return str.substring(str.indexOf(1));
		}
		return "false";
	}

	@RequestMapping("/update")
	@ResponseBody
	public String update(Depatment depatment) {
		if (depatmentService.update(depatment)) {
			return "true";
		}
		return "false";

	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Depatment depatment) {
		if(depatmentService.save(depatment)) {
			return "true";
		}
		return "false";
	}
	@RequestMapping("/removeone")
	@ResponseBody
	public String removeOne(int id) {
		List<Employee> bydfk = employeeService.getBydfk(id);
		if(bydfk.size()>0) {
			return "false";
		}
		if(depatmentService.removeOne(id)) {
			return "true";
		}
		return "false";
		
	}

}









