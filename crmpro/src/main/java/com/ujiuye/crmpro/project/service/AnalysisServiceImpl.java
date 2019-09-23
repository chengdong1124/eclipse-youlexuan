package com.ujiuye.crmpro.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.project.mapper.AnalysisMapper;
import com.ujiuye.crmpro.project.pojo.Analysis;
import com.ujiuye.crmpro.project.pojo.AnalysisExample;
import com.ujiuye.crmpro.project.pojo.AnalysisExample.Criteria;
import com.ujiuye.crmpro.project.pojo.Project;

@Service
public class AnalysisServiceImpl implements AnalysisService {

	@Autowired
	private AnalysisMapper analysisMapper;

	@Autowired
	private ProjectService projectService;

	@Override
	public int countByid(int id) {
		AnalysisExample analysisExample = new AnalysisExample();
		Criteria criteria = analysisExample.createCriteria();
		criteria.andIdEqualTo(id);
		int result = analysisMapper.countByExample(analysisExample);
		return result;
	}

	@Override
	public Analysis getById(int id) {
		Analysis analysis = analysisMapper.selectByPrimaryKey(id);
		return analysis;
	}

	@Override
	public List getByName(String key) {
		AnalysisExample example = new AnalysisExample();
		Criteria criteria = example.createCriteria();
		criteria.andTitleLike("%" + key + "%");
		return analysisMapper.selectByExample(example);
	}

	@Override
	public List list(int type, String key) {
		AnalysisExample example = new AnalysisExample();
		Criteria criteria = example.createCriteria();
		if (type == 1) {
			criteria.andTitleLike("%" + key + "%");
		} else if (type == 2) {
			List list = new ArrayList();
			List<Project> prolist = projectService.list(1, key);
			for (Project project : prolist) {
				list.add(project.getPid());
			
			}
			criteria.andIdIn(list);
		}
		return analysisMapper.selectByExample(example);

	}

	@Override
	public boolean save(Analysis analysis) {
		if(analysisMapper.insertSelective(analysis)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeall(List<Integer> ids) {
		AnalysisExample example = new AnalysisExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		if(analysisMapper.deleteByExample(example)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removOne(int id) {
		if(analysisMapper.deleteByPrimaryKey(id)>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean update(Analysis analysis) {
		if(analysisMapper.updateByPrimaryKeySelective(analysis)>0) {
			return true;
		}
		return false;
	}

}
















