package com.ujiuye.crmpro.message.service;

import java.util.List;

import com.ujiuye.crmpro.message.pojo.Notice;

public interface NoticeService {
	
	boolean save(Notice notice);
	
	List<Notice> list(String key);
	
	Notice getById(int id);
	
}
