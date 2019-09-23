package com.ujiuye.crmpro.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.employee.mapper.ArchivesMapper;
import com.ujiuye.crmpro.employee.pojo.Archives;
import com.ujiuye.crmpro.employee.pojo.ArchivesExample;
import com.ujiuye.crmpro.employee.pojo.ArchivesExample.Criteria;
import com.ujiuye.crmpro.employee.pojo.Employee;

@Service
public class ArchivesServiceImpl implements ArchivesService{
	
	@Autowired
	private ArchivesMapper archivesMapper;
	@Autowired
	private EmployeeService employeeService;

	@Override
	public List<Archives> list(int type, String key) {
		ArchivesExample example = new ArchivesExample();
		Criteria criteria = example.createCriteria();
		List<Integer> list =  new ArrayList<>();
		if(type==1) {
			List<Employee> listEmployee = employeeService.listByName(key);
			for (Employee employee : listEmployee) {
				list.add(employee.getEid());
				criteria.andEmpFkIn(list);
			}
		}else if(type==2){
			criteria.andSchoolLike("%"+key+"%");
		}
		return archivesMapper.selectByExample(example);
	}
	
	@Override
	public boolean saveAll(List<Archives> list) {
		if(archivesMapper.saveAll(list)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(List<String> ids) {
		ArchivesExample example = new ArchivesExample();
		Criteria criteria = example.createCriteria();
		criteria.andNumIn(ids);
		if(archivesMapper.deleteByExample(example)>0) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean save(Archives archives) {
		if(archivesMapper.insertSelective(archives)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Archives getById(String id) {
		Archives archives = archivesMapper.selectByPrimaryKey(id);
		return archives;
	}

	@Override
	public boolean update(Archives archives) {
		if(archivesMapper.updateByPrimaryKeySelective(archives)>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeOne(String id) {
		if(archivesMapper.deleteByPrimaryKey(id)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Archives getByEmpFk(int EmpFk) {
		ArchivesExample example = new ArchivesExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpFkEqualTo(EmpFk);
		List<Archives> list = archivesMapper.selectByExample(example);
		if(list.size()>0) {
			Archives archives = list.get(0);
			return archives;
			
		}
		return null;
	}
}




















