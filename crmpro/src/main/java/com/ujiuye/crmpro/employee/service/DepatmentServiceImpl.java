package com.ujiuye.crmpro.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.employee.mapper.DepatmentMapper;
import com.ujiuye.crmpro.employee.pojo.Depatment;
import com.ujiuye.crmpro.employee.pojo.DepatmentExample;
import com.ujiuye.crmpro.employee.pojo.DepatmentExample.Criteria;

@Service
public class DepatmentServiceImpl implements DepatmentService{

	@Autowired
	private DepatmentMapper depatmentMapper;
	
	@Override
	public List<Depatment> list(int type,String key) {
		DepatmentExample example = new DepatmentExample();
		Criteria criteria = example.createCriteria();
		if(type==1) {
			criteria.andDeptnoEqualTo(Integer.parseInt(key));
		}else if(type==2){
			criteria.andDnameLike(key);
		}else if(type==3){
			criteria.andDlocationLike(key);
		}
		return depatmentMapper.selectByExample(example);
		
	}

	@Override
	public boolean removeAll(List<Integer> ids) {
		DepatmentExample example = new DepatmentExample();
		Criteria criteria = example.createCriteria();
		criteria.andDeptnoIn(ids);
		if(depatmentMapper.deleteByExample(example)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Depatment depatment) {
		if(depatmentMapper.updateByPrimaryKeySelective(depatment)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean save(Depatment depatment) {
		if(depatmentMapper.insertSelective(depatment)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeOne(int id) {
		if(depatmentMapper.deleteByPrimaryKey(id)>0) {
			return true;
		}
		return false;
	}

}














