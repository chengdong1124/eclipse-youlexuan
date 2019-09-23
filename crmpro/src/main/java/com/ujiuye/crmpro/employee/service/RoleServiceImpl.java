package com.ujiuye.crmpro.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.employee.mapper.RoleMapper;
import com.ujiuye.crmpro.employee.pojo.Role;
import com.ujiuye.crmpro.employee.pojo.RoleExample;
import com.ujiuye.crmpro.employee.pojo.RoleExample.Criteria;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> list(int type, String key) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		if(type==1) {
			criteria.andRolenameLike("%"+key+"%");
		}else if(type==2){
			criteria.andRoledisLike("%"+key+"%");
		}else if(type==3) {
			if(key.equals("ÊÇ")) {
				criteria.andStatusEqualTo(1);
			}else {
				criteria.andStatusEqualTo(0);
			}
		}
		return roleMapper.selectByExample(example);
	}

	@Override
	public boolean removeAll(List<Integer> ids) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidIn(ids);
		if(roleMapper.deleteByExample(example)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Role getById(int id) {
		
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean update(Role role) {
		if(roleMapper.updateByPrimaryKeySelective(role)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean save(Role role) {
		if(roleMapper.insertSelective(role)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeOne(int id) {
		if(roleMapper.deleteByPrimaryKey(id)>0) {
			return true;
		}
		return false;
	}
	
	

}





















