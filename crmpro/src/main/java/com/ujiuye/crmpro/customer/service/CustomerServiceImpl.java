package com.ujiuye.crmpro.customer.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.customer.mapper.CustomerMapper;
import com.ujiuye.crmpro.customer.pojo.Customer;
import com.ujiuye.crmpro.customer.pojo.CustomerExample;
import com.ujiuye.crmpro.customer.pojo.CustomerExample.Criteria;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customer> list() {
		
		return customerMapper.selectByExample(new CustomerExample());
	}
	
	@Override
	public List<Customer> selectBy(String checkName,int status) {
		CustomerExample example = new CustomerExample();
		Criteria criteria = example.createCriteria();
		if(status==1) {
			criteria.andCompanypersonLike("%"+checkName+"%");
			List<Customer> list = customerMapper.selectByExample(example);		
			return list;
		}else if(status==2){
			criteria.andComnameLike("%"+checkName+"%");
			List<Customer> list = customerMapper.selectByExample(example);		
			return list;
		}else {
			List<Customer> list = customerMapper.selectByExample(example);
			return list;
		}
	}

	@Override
	public boolean save(Customer customer) {
		customer.setAddtime(new Date());//看到没直接new Date();
		int insertSelective = customerMapper.insertSelective(customer);	
		if(insertSelective > 0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Customer get(int id) {
		Customer  selectByPrimaryKey = customerMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public boolean update(Customer customer) {
		int updateByPrimaryKeySelective = customerMapper.updateByPrimaryKeySelective(customer);
		if(updateByPrimaryKeySelective>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean removeAll(List<Integer> ids) {
		CustomerExample example = new CustomerExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		int result = customerMapper.deleteByExample(example);
		if(result>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean removeOne(int id) {
		int deleteByPrimaryKey = customerMapper.deleteByPrimaryKey(id);
		if(deleteByPrimaryKey>0) {
			return true;
		}else {
			return false;
		}
	}
	
}

