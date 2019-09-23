package com.ujiuye.crmpro.employee.service;

import java.util.List;

import com.ujiuye.crmpro.employee.pojo.Sources;

public interface SourcesService {
	//常规查询全部
	List<Sources>  list();
	
	List<Sources> listZtree();
	
	Sources getById(int id);
	
	boolean save(Sources sources);
	
	boolean update(Sources sources);
	
	boolean remove(int id);
}
