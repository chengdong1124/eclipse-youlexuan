package com.ujiuye.crmpro.employee.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.crmpro.employee.pojo.Archives;
import com.ujiuye.crmpro.employee.pojo.Depatment;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.employee.service.ArchivesService;
import com.ujiuye.crmpro.employee.service.EmployeeService;
import com.ujiuye.crmpro.utils.FileTypeUtils;
import com.ujiuye.crmpro.utils.FileUtils;
import com.ujiuye.crmpro.utils.UUIDUtils;

@Controller
@RequestMapping("/archives")
public class ArchivesController {
	@Autowired
	private ArchivesService archivesService;
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "key", required = false, defaultValue = "") String key) {
		PageHelper.startPage(pageNum, 10);
		List<Archives> list = archivesService.list(type, key);
		PageInfo<Archives> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		model.addAttribute("key", key);
		return "list-archives";
	}

	@RequestMapping(value = "saveall", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String saveAll(MultipartFile[] myfiles) {
		List<File> uploadFile = FileUtils.upload(myfiles, null); //不传路径直接就在这个路径上获取
		File file = null;
		if (uploadFile.size() > 0) {
			file = uploadFile.get(0); // 集合从0开始
		} else {
			return "nofile";
		}
		List<String> message = new ArrayList<>();

		List<Archives> list = getByExcel(file, message);

		if (list.size() == 0) {
			return "false";
		}
		if (!archivesService.saveAll(list)) {
			return "false";
		}
		if (message.size() > 0) {
			return message.toString();
		}
		return "true";
	}

	private List<Archives> getByExcel(File file, List<String> message) {

		List<Archives> list = new ArrayList();

		try {
			// 创建输入流对象
			FileInputStream fis = new FileInputStream(file);

			HSSFWorkbook workbook = new HSSFWorkbook(fis);

			HSSFSheet sheet = workbook.getSheetAt(0);

			int totleRows = sheet.getPhysicalNumberOfRows();

			for (int i = 2; i <= totleRows; i++) {

				HSSFRow row = sheet.getRow(i);

				String name = row.getCell(0).getStringCellValue();

				Employee employee = employeeService.getByName(name);

				if (employee == null) {

					message.add(name);

					continue;
				}

				String school = row.getCell(1).getStringCellValue();

				String major = row.getCell(2).getStringCellValue();

				Date graudatetime = row.getCell(3).getDateCellValue();

				String eductaion = row.getCell(4).getStringCellValue();

				String policstatus = row.getCell(5).getStringCellValue();

				String nation = row.getCell(6).getStringCellValue();

				String contact = row.getCell(7).getStringCellValue();

				String email = row.getCell(8).getStringCellValue();

				String telephone = row.getCell(9).getStringCellValue();

				String remark = row.getCell(10).getStringCellValue();

				Date hiredate = employee.getHiredate();

				Integer empFk = employee.getEid();

				String uuid = UUIDUtils.uuid();

				list.add(new Archives(uuid, telephone, school, major, contact, graudatetime, policstatus, nation,
						eductaion, email, empFk, remark, hiredate));
			}
		} catch (Exception e) {

		}
		return list;

	}

	@RequestMapping("/removeall")
	@ResponseBody
	public String removeAll(Archives archives) {
		List<String> ids = archives.getIds();
		if(archivesService.removeAll(ids)) {
			return "true";
		}
		return "false";

	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Archives archives,String name) {
		Employee employee = employeeService.getByName(name);
		Integer eid = employee.getEid();
		archives.setEmpFk(eid);
		String uuid = UUIDUtils.uuid();
		archives.setNum(uuid);
		if(archivesService.save(archives)) {
			return "true";
		}
		
		return "false";

	}
	
	@RequestMapping("/show")
	public String show(Model model,String id) {
		Archives archives = archivesService.getById(id);
		model.addAttribute("archives", archives);
		return "show-archives";

	}
	
	@RequestMapping("/toupdate")
	public String toUpdate(Model model,String id) {
		Archives archives = archivesService.getById(id);
		model.addAttribute("archives", archives);
		return "update-archives";
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Archives archives) {
		if(archivesService.update(archives)) {
			return "true";
		}
		return "false";
		
	}
	
	@RequestMapping("/removeone")
	@ResponseBody
	public String removeone(String id) {
		if(archivesService.removeOne(id)) {
			return "true";
		}
		return "false";
		
	}
	
	
	

}



















