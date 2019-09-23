package com.ujiuye.crmpro.project.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.crmpro.customer.pojo.Customer;
import com.ujiuye.crmpro.project.pojo.Analysis;
import com.ujiuye.crmpro.project.pojo.Project;
import com.ujiuye.crmpro.project.service.AnalysisService;
import com.ujiuye.crmpro.project.service.AttachmentService;
import com.ujiuye.crmpro.project.service.ProjectService;
import com.ujiuye.crmpro.utils.FileUtils;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private AnalysisService analysisService;

	@Autowired
	private AttachmentService attachmentService;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key) {

		PageHelper.startPage(pageNum, 5);

		List<Project> list = projectService.list(type, key);

		PageInfo<Project> page = new PageInfo<>(list);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("type", type);
		model.addAttribute("key", key);
		return "list-project";

	}
	
	@RequestMapping("/listall")
	@ResponseBody
	public String listAll() {
		
		List<Project> list = projectService.list(0, null);   //自己直接调用自己这一层的方法
		return JSON.toJSONString(list);		
	}
	
	@RequestMapping("/listsome")
	@ResponseBody
	public String listSome() {
		
		List<Project> list = projectService.list(0, null);
		for (int i=list.size()-1;i>=0;i--) {
			Analysis analysis = new Analysis();
			Analysis byId = analysisService.getById(list.get(i).getPid());
			if(byId!=null) {
				list.remove(i);
			}
		}
		return JSON.toJSONString(list);		
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Project project) {
		boolean save = projectService.save(project);
		if (save) {
			return "true";
		} else {
			return "false";
		}
	}

	@RequestMapping("removeall")
	@ResponseBody
	public String removeAll(Project project) {
		List<Integer> ids = project.getIds();
		String canNotDel = "";
		for (int i = ids.size() - 1; i >= 0; i--) {
			int id = ids.get(i);
			if (analysisService.countByid(id) > 0 || attachmentService.countByProFk(id) > 0) {
				ids.remove(i);
				canNotDel += "," + id;
			}
		}
		if (ids.size() == 0) {
			return "false";
		}
		if (projectService.removeAll(ids)) {
			if (canNotDel.length() == 0) {
				return "true";
			} else {
				return canNotDel.substring(1);
			}
		}
		return "false";
	}
	@RequestMapping("/removeOne")
	@ResponseBody
	public String removeOne(int pid) {
		if(analysisService.countByid(pid) > 0 || attachmentService.countByProFk(pid) > 0) {
			return "false";
		}else if(projectService.removeOne(pid)){
			return "true";
		}else {
			return "false";
		}	
	}
	
	@RequestMapping("/getById")
	public String getById(int pid,Model model,int status) {	
		Project project = projectService.getById(pid);
		model.addAttribute("project", project);
		if(status==1) {
			return "show-project";
		}else {
			return "update-project";
		}	
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Project project) {
		boolean result = projectService.update(project);
		if(result) {
			return "true";
		}else {
			return "false";	
		}
	
	}
	
	@RequestMapping("/getexcel")
	public ResponseEntity<byte[]> getExcel(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key) {
		
		PageHelper.startPage(pageNum, 5);
		List<Project> list = projectService.list(type, key);
		String 	path = "E:\\upload\\excel\\";
		File file = createExcel(list,path);
		ResponseEntity<byte[]> download = FileUtils.download(file.getName(), path);
		return download;//这里返回值必须是他，不然不能下载
	}
	
	private File createExcel(List<Project> list,String path) {
		//创建一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一张表页面
		HSSFSheet sheet = workbook.createSheet();
		//创建行头
		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("选择");
		headRow.createCell(1).setCellValue("序号");
		headRow.createCell(2).setCellValue("项目名称");
		headRow.createCell(3).setCellValue("客户公司名称");
		headRow.createCell(4).setCellValue("客户方负责人");
		headRow.createCell(5).setCellValue("项目经理");	
		headRow.createCell(6).setCellValue("开发人员数");
		headRow.createCell(7).setCellValue("立项时间");
		headRow.createCell(8).setCellValue("开始时间");
		headRow.createCell(9).setCellValue("计划完成时间");
		headRow.createCell(10).setCellValue("状态");
		headRow.createCell(11).setCellValue("预估成本");
		headRow.createCell(12).setCellValue("级别");
		headRow.createCell(13).setCellValue("备注");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		for(int i=0;i<list.size();i++) {
			Project project = list.get(i);
			HSSFRow row = sheet.createRow(i+1);
			
			row.createCell(0).setCellValue(project.getPid());
			row.createCell(1).setCellValue(project.getPid());
			row.createCell(2).setCellValue(project.getPname());
			row.createCell(3).setCellValue(project.getCustomer().getComname());
			row.createCell(4).setCellValue(project.getCustomer().getCompanyperson());
			row.createCell(5).setCellValue(project.getEmployee().getEname());	
			row.createCell(6).setCellValue(project.getEmpcount());
			row.createCell(7).setCellValue(format.format(project.getBuildtime()));
			row.createCell(8).setCellValue(format.format(project.getStarttime()));
			row.createCell(9).setCellValue(format.format(project.getEndtime()));
			row.createCell(10).setCellValue("进行中");
			row.createCell(11).setCellValue(project.getCost());
			String level="";
			if(project.getLevel().equals("1")){
				level="一般";
			}else if(project.getLevel().equals("2")) {
				level="紧急";
			}else {
				level="暂缓";
			}
			row.createCell(12).setCellValue(level);
			row.createCell(13).setCellValue(project.getRemark());
		}
		//创建一个新名字
		Date date = new Date();
		format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = format.format(date);
		//生成六位随机数
		String random = String.valueOf(Math.random()).substring(3, 9);
		File file = new File(path+"项目数据"+dateString+random+".xlsx");
		try {
			workbook.write(file);
			return file;
		} catch (IOException e) {
			System.out.println("Excel表格创建失败");
			return null;
		}
	}
	
	
}

















