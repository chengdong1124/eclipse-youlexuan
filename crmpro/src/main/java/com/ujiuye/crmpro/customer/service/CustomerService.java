package com.ujiuye.crmpro.customer.service;

import java.util.List;

import com.ujiuye.crmpro.customer.pojo.Customer;

public interface CustomerService {
	
	List<Customer> list();
	boolean save (Customer customer);
	Customer get(int id);
	boolean update(Customer customer);
	boolean removeAll(List<Integer> ids);
	boolean removeOne(int id);
	List<Customer> selectBy(String checkName,int status);
}
