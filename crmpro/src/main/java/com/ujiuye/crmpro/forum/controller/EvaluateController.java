package com.ujiuye.crmpro.forum.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.forum.pojo.Evaluate;
import com.ujiuye.crmpro.forum.service.EvaluateService;

@Controller
@RequestMapping("/evaluate")
public class EvaluateController {

	@Autowired
	private EvaluateService evaluateService;

	@RequestMapping("/save")
	@ResponseBody
	public String save(Evaluate evaluate,HttpSession session) {
		Employee employee = (Employee)session.getAttribute("LOGIN");
		evaluate.setEmpFk4(employee.getEid());
		evaluate.setEvatime(new Date());
		if (evaluateService.save(evaluate)) {
			return "true";
		}
		return "false";

	}

	@RequestMapping("/remove")
	@ResponseBody
	public String remove(int id) {
		if (evaluateService.remove(id)) {
			return "true";
		}
		return "false";

	}
}














