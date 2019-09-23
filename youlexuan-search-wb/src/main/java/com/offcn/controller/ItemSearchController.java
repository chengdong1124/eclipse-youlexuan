package com.offcn.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offcn.service.ItemSearchService;

@RestController
@RequestMapping("/ItemSearch")
public class ItemSearchController {

	
	@Autowired
	private ItemSearchService itemSearchService;
	
	@RequestMapping("/search")
	public Map<String,Object> search(@RequestBody Map searchMap){
		
		return itemSearchService.search(searchMap);
		
	}
}

















