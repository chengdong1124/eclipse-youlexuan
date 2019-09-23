package com.ujiuye.crmpro.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.employee.mapper.SourcesMapper;
import com.ujiuye.crmpro.employee.pojo.Sources;
import com.ujiuye.crmpro.employee.pojo.SourcesExample;
import com.ujiuye.crmpro.employee.pojo.SourcesExample.Criteria;

@Service
public class SourcesServiceImpl implements SourcesService{
	
	@Autowired
	private SourcesMapper sourcesMapper;

	@Override
	public List<Sources> list() {
		
		return sourcesMapper.selectByExample(null);
	}

	@Override
	public List<Sources> listZtree() {
		SourcesExample example=new SourcesExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(0);
		//先查最项层的菜单
		List<Sources> list = sourcesMapper.selectByExample(example);
		if (list.size()>0) {
			for (Sources sources : list) {
				findChildren(sources);
			}
		}
		return list;
	}
	
	public void findChildren(Sources sources) {
		Integer id = sources.getId();
		SourcesExample example=new SourcesExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(id);
		//先查最项层的菜单
		List<Sources> list = sourcesMapper.selectByExample(example);
		if(list.size()>0) {//如果有子菜单
			for (Sources child : list) {
				findChildren(child);
			}
			sources.setChildren(list);
		}
	}

	@Override
	public Sources getById(int id) {
		
		return sourcesMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean save(Sources sources) {
		try {
			if(sourcesMapper.insertSelective(sources)>0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean update(Sources sources) {
		try {
			if(sourcesMapper.updateByPrimaryKeySelective(sources)>0) {
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
			if(sourcesMapper.deleteByPrimaryKey(id)>0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
		
	}

}




















