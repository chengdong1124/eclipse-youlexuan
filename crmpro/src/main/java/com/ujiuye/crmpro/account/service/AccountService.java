package com.ujiuye.crmpro.account.service;

import java.util.List;

import com.ujiuye.crmpro.account.pojo.Account;

public interface AccountService {
	
	List<Account> listByStatus(int status,int type,String key);
	
	List<Account> listByEmpFk(int emp_fk,int status,String key);
	
	boolean save(Account account);
	
	boolean remove(String id);
	
	boolean update(Account account);
	
	Account getById(String id);
	
	boolean updateStatus(Account account);
}















