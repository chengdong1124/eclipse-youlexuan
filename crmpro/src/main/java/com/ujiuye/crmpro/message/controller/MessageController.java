package com.ujiuye.crmpro.message.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.message.pojo.Message;
import com.ujiuye.crmpro.message.pojo.Notice;
import com.ujiuye.crmpro.message.service.MessageService;
import com.ujiuye.crmpro.utils.FileUtils;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "key", required = false, defaultValue = "") String key,
			@RequestParam(value = "type", required = false, defaultValue = "4") int type,
			HttpSession session) {

		PageHelper.startPage(pageNum, 15);
		Employee employee = (Employee)session.getAttribute("LOGIN");
		List<Message> list = messageService.listByType(employee.getEid(),key,type);
		int count = list.size();
		PageInfo<Message> page = new PageInfo<>(list);
		
		int noread = messageService.countByStatus(employee.getEid(), 1);//未读的数量
		int draft = messageService.countByStatus(employee.getEid(), 2);//草稿的数量
		int rubbish = messageService.countByStatus(employee.getEid(), 3);//垃圾的数量
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("key", key);
		model.addAttribute("noread", noread);
		model.addAttribute("draft", draft);
		model.addAttribute("rubbish", rubbish);
		model.addAttribute("count",count);
		return "list-message";

	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(MultipartFile[] myfiles,Message message,HttpSession session) {
		
		List<File> uploadFile = FileUtils.upload(myfiles, null);
		
		if (uploadFile.size() > 0) {
			
			File file = uploadFile.get(0); // 集合从0开始
			
			message.setPath(file.getName());
		}
		
		message.setTime(new Date());
		
		Employee employee = (Employee)session.getAttribute("LOGIN");
		
		message.setSend(employee.getEid());
		
		if(messageService.save(message)) {
			return "true";
		}
		return "false";
		
	}
	
	@RequestMapping("/show")
	public String show(Model model,int id) {
		Message message = messageService.getById(id);
		model.addAttribute("message", message);
		messageService.update(new Message(id,0));
		return "show-message";
	}
	
	

}



























