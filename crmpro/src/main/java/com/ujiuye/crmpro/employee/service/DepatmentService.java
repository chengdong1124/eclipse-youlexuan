package com.ujiuye.crmpro.employee.service;

import java.util.List;

import com.ujiuye.crmpro.employee.pojo.Depatment;

public interface DepatmentService {
	List<Depatment> list(int type,String key);
	boolean removeAll(List<Integer> ids);
	boolean update(Depatment depatment);
	boolean save(Depatment depatment);
	boolean removeOne(int id);
}
