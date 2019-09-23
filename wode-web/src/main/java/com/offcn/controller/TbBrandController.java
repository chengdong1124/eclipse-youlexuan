package com.offcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offcn.common.PageResult;
import com.offcn.common.Result;
import com.offcn.pojo.TbBrand;
import com.offcn.service.TbBrandService;

@RestController
@RequestMapping("/brand")
public class TbBrandController {

	@Autowired
	private TbBrandService tbBrandService;
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		List<TbBrand> list = tbBrandService.findAll();
		return list;
	}
	

	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		return tbBrandService.findPage(page, rows);
	}

	@RequestMapping("/add")
	public Result addBrand(@RequestBody TbBrand tbBrand) {
		try {
			tbBrandService.addBrand(tbBrand);
			return new Result(true, "添加数据成功");
		} catch (Exception e) {
			return new Result(false, "添加商品失败");
		}
	}

	@RequestMapping("/findOne")
	public TbBrand findOne(long id) {
		TbBrand tbBrand = tbBrandService.findOne(id);
		return tbBrand;

	}

	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand tbBrand) {
		try {
			tbBrandService.updateBrand(tbBrand);
			return new Result(true, "添加更新成功");
		} catch (Exception e) {
			return new Result(false, "添加更新失败");
		}
	}

	@RequestMapping("/delete")
	public Result deleteBrand(Long[] ids) {
		try {
			tbBrandService.deleteBrand(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			return new Result(false, "删除失败");
		}
	}

}















