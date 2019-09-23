package com.offcn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.common.MD5Utils;
import com.offcn.dao.TbAddressMapper;
import com.offcn.dao.TbUserMapper;
import com.offcn.pojo.TbAddress;
import com.offcn.pojo.TbAddressExample;
import com.offcn.pojo.TbAddressExample.Criteria;
import com.offcn.pojo.TbUser;
import com.offcn.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private TbUserMapper tbUserMapper;
	@Autowired
	private TbAddressMapper tbAddressMapper;

	@Override
	public void addUser(TbUser user) {
		user.setUpdated(new Date());
		user.setCreated(new Date());
		String password = user.getPassword();
		String md5 = MD5Utils.md5(password);
		user.setPassword(md5);
		tbUserMapper.insertSelective(user);
		
	}

	@Override
	public List<TbUser> findAll() {
		List<TbUser> list = tbUserMapper.selectByExample(null);
		return list;
	}

	@Override
	public List<TbAddress> findAddressByUserName(String userId) {
		TbAddressExample example = new TbAddressExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<TbAddress> list = tbAddressMapper.selectByExample(example);
		return list;
	}
	

}
