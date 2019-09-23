package com.ujiuye.crmpro.forum.service;

import java.util.List;

import com.ujiuye.crmpro.forum.pojo.Forumsort;

public interface ForumsortService {
	
	List<Forumsort> list();
	
	//更新浏览量
	boolean updateClickById(int id);
	
	//更新帖子数
	boolean updateCountById(int id);
}
