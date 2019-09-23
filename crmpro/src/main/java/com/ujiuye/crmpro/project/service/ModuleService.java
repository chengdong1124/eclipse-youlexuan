package com.ujiuye.crmpro.project.service;

import java.util.List;

import com.ujiuye.crmpro.project.pojo.Module;

public interface ModuleService {
	List<Module> listByAnalysisFk(int analysis_fk);
	List<Module> listByName(String key);
	List<Module> list(int type,String key);
	boolean save(Module module);
	boolean removeAll(List<Integer> ids);
	Module getById(int id);
	boolean update(Module module);
	boolean removeOne(int id);
}
