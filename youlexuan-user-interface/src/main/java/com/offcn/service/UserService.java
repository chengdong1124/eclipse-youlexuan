package com.offcn.service;

import java.util.List;

import com.offcn.pojo.TbAddress;
import com.offcn.pojo.TbUser;

public interface UserService {

	public void addUser(TbUser user);
	
	public List<TbUser> findAll();
	
	public List<TbAddress> findAddressByUserName(String userId);
	
}
