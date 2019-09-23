package com.ujiuye.crmpro.project.service;

import java.util.List;

import com.ujiuye.crmpro.project.pojo.Analysis;

public interface AnalysisService {
	
	int countByid(int id);
	Analysis getById(int id);
	List getByName(String key);
	List list(int type,String key);
	boolean save(Analysis analysis);
	boolean removeall(List<Integer> ids);
	boolean removOne(int id);
	boolean update(Analysis analysis);
}
