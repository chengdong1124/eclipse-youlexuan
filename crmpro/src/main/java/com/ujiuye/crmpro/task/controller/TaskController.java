package com.ujiuye.crmpro.task.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.project.pojo.Project;
import com.ujiuye.crmpro.task.pojo.Task;
import com.ujiuye.crmpro.task.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key) {

		PageHelper.startPage(pageNum, 5);

		List<Task> list = taskService.list(type, key);

		PageInfo<Task> page = new PageInfo<>(list);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("type", type);
		model.addAttribute("key", key);

		return "list-task";

	}

	@RequestMapping("/mylist")
	public String Mylist(Model model,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key, HttpSession session) {

		Employee employee = (Employee) session.getAttribute("LOGIN");//这个地方要强转

		PageHelper.startPage(pageNum, 5);

		List<Task> list = taskService.listByEmpFk(employee.getEid(), type, key);

		PageInfo<Task> page = new PageInfo<>(list);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("type", type);
		model.addAttribute("key", key);
		return "list-mytask";

	}

	@RequestMapping("/updatestatus")
	@ResponseBody
	public String updateStatus(Task task) {
		if (taskService.update(task)) {
			return "true";
		}
		return "false";

	}

	@RequestMapping("/save")
	@ResponseBody
	public String save(Task task, HttpSession session) {

		Employee employee = (Employee) session.getAttribute("LOGIN");
		task.setStatus(0);
		task.setEmpFk(employee.getEid());

		if (taskService.save(task)) {
			return "true";
		}
		return "false";

	}
}
