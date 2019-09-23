package com.ujiuye.crmpro.project.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.crmpro.project.pojo.Attachment;
import com.ujiuye.crmpro.project.pojo.Project;
import com.ujiuye.crmpro.project.service.AttachmentService;
import com.ujiuye.crmpro.utils.FileTypeUtils;
import com.ujiuye.crmpro.utils.FileUtils;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {

	@Autowired
	private AttachmentService attachmentService;
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "key", required = false, defaultValue = "") String key) {

		PageHelper.startPage(pageNum, 20);

		List<Attachment> list = attachmentService.list(key);

		PageInfo<Attachment> page = new PageInfo<>(list);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("key", key);
		return "list-attachment";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(MultipartFile[] myfiles,Attachment attachment) { //看到没，文件和form表单其他数据是分开接收的
		List<File> upload = FileUtils.upload(myfiles, null);
		if(upload.size()>0) {
			File file = upload.get(0);	//集合从0开始
			attachment.setPath(file.getName());
			attachment.setType(FileTypeUtils.getType(file.getName()));
		}else {
			return "nofile";
		}
		if(attachmentService.save(attachment)) {
			return "true";
		}
		return "false";
		
	}
	@RequestMapping("/show")
	public String show(Model model,int id) {
		Attachment attachment = attachmentService.getById(id);
		model.addAttribute("attachment", attachment);
		return "show-attachment";
		
	}
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(String fileName) { //返回值必须是这个否则无法下载
		
		return FileUtils.download(fileName, null);
		
	}
	@RequestMapping("/listbytype")
	public String listByType(Model model,int type) {
		List<Attachment> list = attachmentService.listByType(type);
		model.addAttribute("list", list);
		return "list-attachment";
		
	}
	
	
	
	
}






















