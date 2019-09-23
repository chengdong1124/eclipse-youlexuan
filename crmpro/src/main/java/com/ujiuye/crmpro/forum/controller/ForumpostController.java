package com.ujiuye.crmpro.forum.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.forum.pojo.Evaluate;
import com.ujiuye.crmpro.forum.pojo.Forumpost;
import com.ujiuye.crmpro.forum.service.EvaluateService;
import com.ujiuye.crmpro.forum.service.ForumpostService;
import com.ujiuye.crmpro.forum.service.ForumsortService;
import com.ujiuye.crmpro.project.pojo.Analysis;

@Service
@RequestMapping("/forumpost")
public class ForumpostController {

	@Autowired
	private ForumpostService forumpostService;

	@Autowired
	private ForumsortService forumsortService;
	
	@Autowired
	private EvaluateService evaluateService;
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			int forumsort_kf) {
		
		PageHelper.startPage(pageNum, 8);
		forumsortService.updateClickById(forumsort_kf);// ‰Ø¿¿¡ø+1
		List<Forumpost> list = forumpostService.list(forumsort_kf);
		PageInfo<Forumpost> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		return "list-forum";

	}

	@RequestMapping("/show")
	public String show(Model model, int id) {
		Forumpost forumpost = forumpostService.getById(id);
		forumpostService.updateClickById(id);// ‰Ø¿¿¡ø+1
		List<Evaluate> list = evaluateService.listByForumFk(id);
		model.addAttribute("forumpost", forumpost);
		model.addAttribute("list", list);
		return "show-forum";

	}

	@RequestMapping("/save")
	@ResponseBody
	public String save(Forumpost forumpost, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("LOGIN");
		forumpost.setEmpFk3(employee.getEid());
		forumpost.setCreatetime(new Date());
		forumpost.setClick(0);
		forumpost.setCommentCount(0);
		if (forumpostService.save(forumpost)) {
			return "true";
		}

		return "false";

	}

}










