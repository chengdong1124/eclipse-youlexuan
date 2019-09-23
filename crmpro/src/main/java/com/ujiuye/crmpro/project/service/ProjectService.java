package com.ujiuye.crmpro.project.service;

import java.util.List;

import com.ujiuye.crmpro.project.pojo.Project;

public interface ProjectService {
	List<Project> list(int type,String key);
	boolean save(Project project);
	boolean removeAll(List<Integer> ids);
	boolean removeOne(int pid);
	Project getById(int pid);
	boolean update(Project project);
	
}
