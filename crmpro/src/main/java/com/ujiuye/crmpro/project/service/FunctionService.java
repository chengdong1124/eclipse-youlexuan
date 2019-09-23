package com.ujiuye.crmpro.project.service;

import java.util.List;

import com.ujiuye.crmpro.project.pojo.Function;

public interface FunctionService {

	List<Function> list();
	List<Function> list(int type,String key);
	Function getById(int id);
	boolean update(Function function);
	boolean save(Function function);
	boolean remove(int id);
	boolean removeAll(List<Integer> ids);
	Function toUpdate(int id);
	List<Function> listByModleId(int fk);
	List<Function> listByAnalysisName(int analysisname);
}
