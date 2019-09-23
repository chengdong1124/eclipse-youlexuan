package com.ujiuye.crmpro.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.project.mapper.FunctionMapper;
import com.ujiuye.crmpro.project.mapper.ModuleMapper;
import com.ujiuye.crmpro.project.pojo.Analysis;
import com.ujiuye.crmpro.project.pojo.Function;
import com.ujiuye.crmpro.project.pojo.FunctionExample;
import com.ujiuye.crmpro.project.pojo.FunctionExample.Criteria;
import com.ujiuye.crmpro.project.pojo.Module;
import com.ujiuye.crmpro.project.pojo.ModuleExample;
import com.ujiuye.crmpro.project.pojo.Project;

@Service
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	private FunctionMapper functionMapper;
	@Autowired
	private ModuleService ModuleService;
	@Autowired
	private AnalysisService analysisService;
	@Autowired
	private ProjectService projectService;

	@Override
	public List<Function> list() {
		return functionMapper.selectByExample(new FunctionExample());
	}

	@Override
	public List<Function> list(int type, String key) {
		FunctionExample example = new FunctionExample();
		Criteria criteria = example.createCriteria();
		
		if (type == 1) {
			criteria.andFunctionnameLike("%" + key + "%");
			
		} else if (type == 2) {
			List<Module> ByNamelist = ModuleService.listByName(key);
			List<Integer> list = new ArrayList();
			if (ByNamelist.size() > 0) {
				for (Module module : ByNamelist) {
					list.add(module.getId());
				}
			}
			criteria.andModuleFkIn(list);
		}else if(type == 3) {
			List<Analysis> byName = analysisService.getByName(key);
			List<Integer> list = new ArrayList();
			if(byName.size()>0) {
				for (Analysis analysis : byName) {
					list.add(analysis.getId());
				}
			}
			criteria.andAnalysisnameIn(list);
		}else if(type == 4) {
			List<Project> listProject = projectService.list(1, key);
			List<Integer> list = new ArrayList();
			if(listProject.size()>0) {
				for (Project project : listProject) {
					list.add(project.getPid());
				}
			}
			criteria.andPronameIn(list);
		}
		
		return functionMapper.selectByExample(example);
	}

	
	@Override
	public Function getById(int id) {
		return functionMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean update(Function function) {
		function.setUpdatetime(new Date());
		if (functionMapper.updateByPrimaryKeySelective(function) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean save(Function function) {
		function.setAddtime(new Date());
		function.setUpdatetime(new Date());
		if (functionMapper.insertSelective(function) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(int id) {
		int deleteByPrimaryKey = functionMapper.deleteByPrimaryKey(id);
		if (deleteByPrimaryKey > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(List<Integer> ids) {
		FunctionExample example = new FunctionExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		int deleteByExample = functionMapper.deleteByExample(example);
		if (deleteByExample > 0) {
			return true;
		}
		return false;
	}
	public Function toUpdate(int id) {
		Function function = functionMapper.selectByPrimaryKey(id);
		
		return function;
		
	}

	@Override
	public List<Function> listByModleId(int fk) {
		FunctionExample example = new FunctionExample();
		Criteria criteria = example.createCriteria();
		criteria.andModuleFkEqualTo(fk);
		
		return functionMapper.selectByExample(example);
	}

	@Override
	public List<Function> listByAnalysisName(int analysisname) {
		FunctionExample example = new FunctionExample();
		Criteria criteria = example.createCriteria();
		criteria.andAnalysisnameEqualTo(analysisname);
		return functionMapper.selectByExample(example);
	}
}










