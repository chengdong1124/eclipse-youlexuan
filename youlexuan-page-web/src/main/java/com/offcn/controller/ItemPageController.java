package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offcn.service.ItemPageService;

@RestController
@RequestMapping("/page")
public class ItemPageController {
	
	@Autowired
	private ItemPageService itemPageService;
	
	
	@RequestMapping("/getHtml")
	public void getHtml(long goodId) {
		itemPageService.getItemHtml(goodId);
	}
}
