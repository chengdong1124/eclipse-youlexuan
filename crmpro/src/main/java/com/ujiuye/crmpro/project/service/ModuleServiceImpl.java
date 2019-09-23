package com.ujiuye.crmpro.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.project.mapper.ModuleMapper;
import com.ujiuye.crmpro.project.pojo.Analysis;
import com.ujiuye.crmpro.project.pojo.Module;
import com.ujiuye.crmpro.project.pojo.ModuleExample;
import com.ujiuye.crmpro.project.pojo.ModuleExample.Criteria;

@Service
public class ModuleServiceImpl implements ModuleService{

	@Autowired
	private ModuleMapper moduleMapper;
	@Autowired
	private AnalysisService analysisService;
	
	@Override
	public List<Module> listByAnalysisFk(int analysis_fk) {
		ModuleExample example = new ModuleExample();
		Criteria criteria = example.createCriteria();
		criteria.andAnalysisFkEqualTo(analysis_fk);
		return moduleMapper.selectByExample(example);
	}
	@Override
	public List<Module> listByName(String key) {
		ModuleExample example = new ModuleExample();
		Criteria criteria = example.createCriteria();
		criteria.andModelnameLike("%"+key+"%");
		List<Module> list = moduleMapper.selectByExample(example);
		return list;
	}
	@Override
	public List<Module> list(int type, String key) {
		ModuleExample example = new ModuleExample();
		Criteria criteria = example.createCriteria();
		if(type==1) {
			criteria.andModelnameLike("%"+key+"%");
		}else if(type==2) {
			List<Analysis> list = analysisService.getByName(key);
			for (Analysis analysis : list) {
				criteria.andAnalysisFkEqualTo(analysis.getId());
			}
		}else if(type==3){
			criteria.andProjectnameLike(key);
		}
		return moduleMapper.selectByExample(example);
	}
	@Override
	public boolean save(Module module) {
		if(moduleMapper.insertSelective(module)>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean removeAll(List<Integer> ids) {
		ModuleExample example = new ModuleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		
		if(moduleMapper.deleteByExample(example)>0) {
			return true;
		}
		return false;
	}
	@Override
	public Module getById(int id) {
		Module module = moduleMapper.selectByPrimaryKey(id);
		return module;
	}
	@Override
	public boolean update(Module module) {
		if(moduleMapper.updateByPrimaryKeySelective(module)>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean removeOne(int id) {
		int deleteByPrimaryKey = moduleMapper.deleteByPrimaryKey(id);
		if(deleteByPrimaryKey>0) {
			return true;
		}
		return false;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
