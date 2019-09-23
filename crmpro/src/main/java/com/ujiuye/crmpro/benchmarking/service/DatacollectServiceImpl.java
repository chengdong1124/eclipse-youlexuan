package com.ujiuye.crmpro.benchmarking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.benchmarking.mapper.DatacollectMapper;
import com.ujiuye.crmpro.benchmarking.pojo.Datacollect;
import com.ujiuye.crmpro.benchmarking.pojo.DatacollectExample;
import com.ujiuye.crmpro.benchmarking.pojo.DatacollectExample.Criteria;

@Service
public class DatacollectServiceImpl implements DatacollectService{
	
	@Autowired
	private DatacollectMapper datacollectMapper;

	@Override
	public List<Datacollect> list(int type, String key) {
		DatacollectExample example = new DatacollectExample();
		Criteria criteria = example.createCriteria();
		if(type==1) {
			criteria.andDacnameLike("%"+key+"%");
		}else if(type==2){
			criteria.andDabusinessLike("%"+key+"%");
		}
		return datacollectMapper.selectByExample(example);
	}

	@Override
	public boolean removeAll(List<Integer> ids) {
		DatacollectExample example = new DatacollectExample();
		Criteria criteria = example.createCriteria();
		criteria.andDaidIn(ids);
		
		if(datacollectMapper.deleteByExample(example)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Datacollect getById(int id) {
		Datacollect datacollect = datacollectMapper.selectByPrimaryKey(id);
		return datacollect;
	}

	@Override
	public boolean removeOne(int id) {
		int deleteByPrimaryKey = datacollectMapper.deleteByPrimaryKey(id);
		if(deleteByPrimaryKey>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean save(Datacollect datacollect) {
		if(datacollectMapper.insertSelective(datacollect)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Datacollect datacollect) {
		if(datacollectMapper.updateByPrimaryKeySelective(datacollect)>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Datacollect> getByName(String key) {
		DatacollectExample example = new DatacollectExample();
		Criteria criteria = example.createCriteria();
		criteria.andDacnameLike("%"+key+"%");
		return datacollectMapper.selectByExample(example);
	}
	
	

}




























