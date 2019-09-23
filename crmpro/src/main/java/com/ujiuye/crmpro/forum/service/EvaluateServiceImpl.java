package com.ujiuye.crmpro.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.forum.mapper.EvaluateMapper;
import com.ujiuye.crmpro.forum.pojo.Evaluate;
import com.ujiuye.crmpro.forum.pojo.EvaluateExample;
import com.ujiuye.crmpro.forum.pojo.EvaluateExample.Criteria;

@Service
public class EvaluateServiceImpl implements EvaluateService{

	@Autowired
	private EvaluateMapper evaluateMapper;
	@Autowired
	private ForumpostService forumpostService;
	@Override
	public List<Evaluate> listByForumFk(int forum_Fk) {
		EvaluateExample example = new EvaluateExample();
		example.setOrderByClause("evatime desc");
		Criteria criteria = example.createCriteria();
		criteria.andForumFkEqualTo(forum_Fk);
		return evaluateMapper.selectByExample(example);
	}

	@Override
	public boolean save(Evaluate evaluate) {
		try {
			if(evaluateMapper.insertSelective(evaluate)>0) {
				forumpostService.updateCommentById(evaluate.getForumFk());
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean remove(int id) {
		try {
			if(evaluateMapper.deleteByPrimaryKey(id)>0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
		
	}

}














