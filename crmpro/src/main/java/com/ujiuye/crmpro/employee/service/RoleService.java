package com.ujiuye.crmpro.employee.service;

import java.util.List;

import com.ujiuye.crmpro.employee.pojo.Role;

public interface RoleService {
	List<Role> list(int type,String key);
	boolean removeAll(List<Integer> ids);
	Role getById(int id);
	boolean update(Role role);
	boolean save(Role role);
	boolean removeOne(int id);
}
