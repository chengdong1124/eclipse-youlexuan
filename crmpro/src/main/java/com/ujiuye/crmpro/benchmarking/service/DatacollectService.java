package com.ujiuye.crmpro.benchmarking.service;

import java.util.List;

import com.ujiuye.crmpro.benchmarking.pojo.Datacollect;

public interface DatacollectService {
	
	List<Datacollect> list(int type,String key);
	
	boolean removeAll(List<Integer> ids);
	
	Datacollect getById(int id);
	
	boolean removeOne(int id);
	
	boolean save(Datacollect datacollect);
	
	boolean update(Datacollect datacollect);
	
	List<Datacollect> getByName(String key);
	
}
