package com.ujiuye.crmpro.task.service;

import java.util.List;

import com.ujiuye.crmpro.task.pojo.Task;

public interface TaskService {
	
	List<Task> list(int type,String key);
	
	//我的任务
	List<Task> listByEmpFk(int emp_fk,int type,String key);
	
	Task getById(int id);
	
	List getByfunFk(int funFk);
	
	boolean save(Task task);
	
	boolean update(Task task);
	
	boolean remove(int id);
	
	boolean removeAll(List<Integer> ids);
	

}
