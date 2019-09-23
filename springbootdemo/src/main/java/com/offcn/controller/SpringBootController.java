package com.offcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.offcn.pojo.TbBrand;
import com.offcn.service.BrandService;

//yml

@RestController
public class SpringBootController {

	@Autowired
	private BrandService brandService;
	
	@RequestMapping("/test")
	public String test() {
		return "hello,world";
	}

	@RequestMapping("/brand")
	public TbBrand findOne(long id) {
		TbBrand tbBrand = brandService.findBrandById(id);
		return tbBrand;
	}
	
	@RequestMapping("/findAll")
	public PageInfo<TbBrand> findAll() {
		PageInfo<TbBrand> page = brandService.findAll();
		return page;
	}

}
















