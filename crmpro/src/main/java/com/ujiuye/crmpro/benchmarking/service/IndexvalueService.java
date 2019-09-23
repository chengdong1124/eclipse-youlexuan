package com.ujiuye.crmpro.benchmarking.service;

import java.util.List;

import com.ujiuye.crmpro.benchmarking.pojo.Indexvalue;

public interface IndexvalueService {
	List<Indexvalue> getBydatacollectFk(int id);
	
	List<Indexvalue> list(int type,String key);
	
	boolean removeAll(List<Integer> ids);
	
	Indexvalue getById(int id);
	
	boolean save(Indexvalue indexvalue);
	
	boolean update(Indexvalue indexvalue);
}
