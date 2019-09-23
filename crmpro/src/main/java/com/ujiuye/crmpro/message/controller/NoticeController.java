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
import com.ujiuye.crmpro.account.pojo.Account;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.message.pojo.Notice;
import com.ujiuye.crmpro.message.service.MessageService;
import com.ujiuye.crmpro.message.service.NoticeService;
import com.ujiuye.crmpro.utils.FileUtils;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "key", required = false, defaultValue = "") String key,
			HttpSession session) {

		PageHelper.startPage(pageNum, 15);
		Employee employee = (Employee)session.getAttribute("LOGIN");
		
		int noread = messageService.countByStatus(employee.getEid(), 1);//δ��������
		int draft = messageService.countByStatus(employee.getEid(), 2);//�ݸ�
		int rubbish = messageService.countByStatus(employee.getEid(), 3);//����
		
		List<Notice> list = noticeService.list(key);
		PageInfo<Notice> page = new PageInfo<>(list);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("key", key);
		model.addAttribute("noread", noread);
		model.addAttribute("draft", draft);
		model.addAttribute("rubbish", rubbish);

		return "list-notice";

	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(MultipartFile[] myfiles,Notice notice) {
		List<File> uploadFiles = FileUtils.upload(myfiles, null);
		if (uploadFiles.size() > 0) {
			File file = uploadFiles.get(0); // ���ϴ�0��ʼ
			notice.setPath(file.getName());	//·������д�������֣��ó�����ʱ��ᵽ�Ǹ�����ļ���Ŀ¼������Ϊ������ļ�
			//ע��set·����ʱ��Ҫ��if���棬��Ȼ�Ļ�û���������ǻ���ɴ���
		}
		notice.setDate(new Date());
		if(noticeService.save(notice)) {
			return "true";
		}
		return "false";
		
	}
	
	@RequestMapping("/show")
	public String show(Model model,int id) {
		Notice notice = noticeService.getById(id);
		model.addAttribute("notice", notice);
		return "show-notice";
	}
	
	

}




























