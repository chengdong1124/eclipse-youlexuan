package com.ujiuye.crmpro.account.controller;

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
import com.ujiuye.crmpro.account.pojo.Account;
import com.ujiuye.crmpro.account.service.AccountService;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.project.pojo.Project;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key, int status) {

		PageHelper.startPage(pageNum, 5);

		List<Account> list = accountService.listByStatus(status, type, key);

		PageInfo<Account> page = new PageInfo<>(list);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("type", type);
		model.addAttribute("key", key);

		if (status == 1) {
			return "list-approve";
		} else if (status == 2) {
			return "list-pay";
		}
		return "list-payed";

	}

	@RequestMapping("/mylist")
	public String myList(Model model,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "status", required = false, defaultValue = "4") int status,
			@RequestParam(value = "key", required = false, defaultValue = "") String key, HttpSession session) {
		PageHelper.startPage(pageNum, 5);
		Employee employee = (Employee) session.getAttribute("LOGIN");
		List<Account> list = accountService.listByEmpFk(employee.getEid(), status, key);
		PageInfo<Account> page = new PageInfo<>(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("status", status);
		model.addAttribute("key", key);
		return "list-myaccount";
	}

	@RequestMapping("/save")
	@ResponseBody
	public String save(Account account, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("LOGIN");
		account.setEmpFk(employee.getEid());
		if (accountService.save(account)) {
			return "true";
		}
		return "false";
	}

	@RequestMapping("/remove")
	@ResponseBody
	public String remove(String id) {
		if (accountService.remove(id)) {
			return "true";
		}
		return "false";

	}
	
	@RequestMapping("/show")
	public String show(Model model,String id,int pageNum) {
		Account account = accountService.getById(id);
		model.addAttribute("account", account);
		model.addAttribute("pageNum", pageNum);
		return "show-myaccount";
	}
	
	@RequestMapping("/toupdate")
	public String toupdate(Model model,String id) {
		Account account = accountService.getById(id);
		model.addAttribute("account", account);
		return "update-myaccount";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Account account) {
		if (accountService.update(account)) {
			return "true";
		}
		return "false";
	}
	
	@RequestMapping("/toapprove")
	public String toApprove(Model model,String id) {
		Account account = accountService.getById(id);
		model.addAttribute("account", account);
		return "update-approve";
	}
	
	@RequestMapping("/updatestatus")
	@ResponseBody
	public String updateStatus(Account account) {
		if(accountService.updateStatus(account)) {
			return "true";
		}
		return "false";
	}
}













