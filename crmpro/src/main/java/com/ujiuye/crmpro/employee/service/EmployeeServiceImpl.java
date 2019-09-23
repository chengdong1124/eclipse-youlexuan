package com.ujiuye.crmpro.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.employee.mapper.EmployeeMapper;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.employee.pojo.EmployeeExample;
import com.ujiuye.crmpro.employee.pojo.EmployeeExample.Criteria;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
	
	@Autowired
	private  EmployeeMapper employeeMapper;
	
	@Override
	public List<Employee> listByName(String key) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEnameLike("%"+key+"%");
		return employeeMapper.selectByExample(example);
	}

	
	@Override
	public List<Employee> listByPFK(int p_fk) {
		EmployeeExample example = new  EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andPFkEqualTo(p_fk);
		return employeeMapper.selectByExample(example);
		
	}


	@Override
	public Employee login(Employee employee) {
		EmployeeExample example = new  EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(employee.getUsername());
		criteria.andPasswordEqualTo(employee.getPassword());
		List<Employee> list = employeeMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}


	@Override
	public List<Employee> list() {
		
		return employeeMapper.selectByExample(new EmployeeExample());
	}


	@Override
	public List<Employee> getBydfk(int fk) {
		EmployeeExample example = new  EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andDFkEqualTo(fk);
		return employeeMapper.selectByExample(example);
	}


	@Override
	public Employee getByName(String name) {
		EmployeeExample example = new  EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEnameEqualTo(name);//注意这里是equalto哦
		List<Employee> list = employeeMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}

}

















