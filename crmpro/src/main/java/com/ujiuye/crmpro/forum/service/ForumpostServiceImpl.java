package com.ujiuye.crmpro.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.forum.mapper.ForumpostMapper;
import com.ujiuye.crmpro.forum.mapper.ForumsortMapper;
import com.ujiuye.crmpro.forum.pojo.Forumpost;
import com.ujiuye.crmpro.forum.pojo.ForumpostExample;
import com.ujiuye.crmpro.forum.pojo.ForumpostExample.Criteria;

@Service
public class ForumpostServiceImpl implements ForumpostService{

	@Autowired
	private ForumpostMapper forumpostMapper;
	@Autowired
	private ForumsortMapper forumsortMapper;
	
	@Override
	public List<Forumpost> list(int forumsort_kf) {
		ForumpostExample example = new ForumpostExample();
		Criteria criteria = example.createCriteria();
		criteria.andForumsortFkEqualTo(forumsort_kf);
		return forumpostMapper.selectByExample(example);
	}

	@Override
	public Forumpost getById(int id) {
		return forumpostMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateClickById(int id) {
		if(forumpostMapper.updateClickById(id)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCommentById(int id) {
		if(forumpostMapper.updateCommentById(id)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean save(Forumpost forumpost) {
		if(forumpostMapper.insertSelective(forumpost)>0) {
			forumsortMapper.updateCountById(forumpost.getForumsortFk());
			return true;
		}
		return false;
	}
	
	

}
















