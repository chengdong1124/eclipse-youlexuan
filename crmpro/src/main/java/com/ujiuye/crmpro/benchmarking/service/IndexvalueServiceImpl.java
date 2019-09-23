package com.ujiuye.crmpro.benchmarking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.benchmarking.mapper.DatacollectMapper;
import com.ujiuye.crmpro.benchmarking.mapper.IndexvalueMapper;
import com.ujiuye.crmpro.benchmarking.pojo.Datacollect;
import com.ujiuye.crmpro.benchmarking.pojo.Indexvalue;
import com.ujiuye.crmpro.benchmarking.pojo.IndexvalueExample;
import com.ujiuye.crmpro.benchmarking.pojo.IndexvalueExample.Criteria;
import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.employee.service.EmployeeService;

@Service
public class IndexvalueServiceImpl implements IndexvalueService{
	
	@Autowired
	private IndexvalueMapper indexvalueMapper;
	@Autowired
	private DatacollectService datacollectService;
	@Autowired
	private EmployeeService employeeService;

	@Override
	public List<Indexvalue> getBydatacollectFk(int id) {
		IndexvalueExample example = new IndexvalueExample();
		Criteria criteria = example.createCriteria();
		criteria.andDatacollectFkEqualTo(id);
		return indexvalueMapper.selectByExample(example);
	}

	@Override
	public List<Indexvalue> list(int type, String key) {
		IndexvalueExample example = new IndexvalueExample();
		Criteria criteria = example.createCriteria();
		List<Integer> list = new ArrayList();
		if(type==1) {
			List<Datacollect> datalist = datacollectService.getByName(key);
			if(list.size()>0) {
				for (Datacollect datacollect : datalist) {
					Integer daid = datacollect.getDaid();
					list.add(daid);
				}
				criteria.andDatacollectFkIn(list);
			}
		}else if(type==2){
			List<Employee> emplist = employeeService.listByName(key);
			for (Employee employee : emplist) {
				Integer eid = employee.getEid();
				list.add(eid);
			}
			criteria.andEmpFk5In(list);
		}
		return indexvalueMapper.selectByExample(example);
	}

	@Override
	public boolean removeAll(List<Integer> ids) {
		IndexvalueExample example = new IndexvalueExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		if(indexvalueMapper.deleteByExample(example)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Indexvalue getById(int id) {
		Indexvalue indexvalue = indexvalueMapper.selectByPrimaryKey(id);
		return indexvalue;
	}

	@Override
	public boolean save(Indexvalue indexvalue) {
		if(indexvalueMapper.insertSelective(indexvalue)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Indexvalue indexvalue) {
		if(indexvalueMapper.updateByPrimaryKeySelective(indexvalue)>0) {
			return true;
		}
		return false;
	}
	
	

}




















