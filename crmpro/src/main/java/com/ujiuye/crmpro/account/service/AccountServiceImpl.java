package com.ujiuye.crmpro.account.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.account.mapper.AccountMapper;
import com.ujiuye.crmpro.account.pojo.Account;
import com.ujiuye.crmpro.account.pojo.AccountExample;
import com.ujiuye.crmpro.account.pojo.AccountExample.Criteria;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.employee.service.EmployeeService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public List<Account> listByStatus(int status, int type, String key) {
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		//报销单号
		if(type==1) {
			criteria.andBxidLike("%"+key+"%");
		}else if(type==2){  //报销人
			List<Employee> emplist = employeeService.listByName(key);
			List<Integer> list = new ArrayList();
			if(emplist.size()>0) {
				for(Employee employee:emplist) {
					list.add( employee.getEid());
				}
			}else {
				list.add(0);
			}
			criteria.andEmpFkIn(list);
		}
		criteria.andBxstatusEqualTo(status);
		return accountMapper.selectByExample(example);
	}

	@Override
	public List<Account> listByEmpFk(int emp_fk, int status, String key) {
		AccountExample example = new AccountExample();
		example.setOrderByClause("bxid");	//排序在example排序
		Criteria criteria = example.createCriteria();
		if(status<4) {
			criteria.andBxstatusEqualTo(status);
		}
		if(key!=null && !key.equals("")) {
			criteria.andBxidLike("%"+key+"%");
		}
		criteria.andEmpFkEqualTo(emp_fk);
		return accountMapper.selectByExample(example);
	}

	@Override
	public boolean save(Account account) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = format.format(date);
		String random = String.valueOf(Math.random()).substring(3, 9);
		String id="BX"+dateString+random;
		account.setBxid(id);
		account.setBxstatus(1);//待审批
		if(accountMapper.insertSelective(account)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(String id) {
		if(accountMapper.deleteByPrimaryKey(id)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Account account) {
		account.setBxstatus(1);
		if(accountMapper.updateByPrimaryKeySelective(account)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Account getById(String id) {
		return accountMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateStatus(Account account) {
		if(accountMapper.updateByPrimaryKeySelective(account)>0) {
			return true;
		}
		return false;
	}

}












