package com.ujiuye.crmpro.employee.service;

import java.util.List;

import com.ujiuye.crmpro.employee.pojo.Archives;

public interface ArchivesService {
	
	List<Archives> list(int type,String key);
	
	boolean saveAll(List<Archives> list);
	
	boolean removeAll(List<String> ids);
	
	boolean save(Archives archives);
	
	Archives getById(String id);
	
	boolean update(Archives archives);
	
	boolean removeOne(String id);
	
	Archives getByEmpFk(int EmpFk);
	
}
