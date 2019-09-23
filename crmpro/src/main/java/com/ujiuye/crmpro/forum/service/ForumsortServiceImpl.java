package com.ujiuye.crmpro.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.forum.mapper.ForumsortMapper;
import com.ujiuye.crmpro.forum.pojo.Forumsort;
import com.ujiuye.crmpro.forum.pojo.ForumsortExample;

@Service
public class ForumsortServiceImpl implements ForumsortService{

	@Autowired
	private ForumsortMapper forumsortMapper;
	
	@Override
	public List<Forumsort> list() {
		
		return forumsortMapper.selectByExample(new ForumsortExample());//或者这里传个null不写example也行
	}

	@Override
	public boolean updateClickById(int id) {
		if(forumsortMapper.updateClickById(id)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCountById(int id) {
		if(forumsortMapper.updateCountById(id)>0) {
			return true;
		}
		return false;
	}

}














