package com.ujiuye.crmpro.forum.service;

import java.util.List;

import com.ujiuye.crmpro.forum.pojo.Forumsort;

public interface ForumsortService {
	
	List<Forumsort> list();
	
	//���������
	boolean updateClickById(int id);
	
	//����������
	boolean updateCountById(int id);
}
