package com.ujiuye.crmpro.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.core.support.ExampleMatcherAccessor;
import org.springframework.stereotype.Service;

import com.ujiuye.crmpro.employee.pojo.Employee;
import com.ujiuye.crmpro.employee.service.EmployeeService;
import com.ujiuye.crmpro.project.mapper.ProjectMapper;
import com.ujiuye.crmpro.project.pojo.Project;
import com.ujiuye.crmpro.project.pojo.ProjectExample;
import com.ujiuye.crmpro.project.pojo.ProjectExample.Criteria;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private EmployeeService employeeService;

	@Override
	public List<Project> list(int type, String key) {
		ProjectExample example = new ProjectExample();
		Criteria criteria = example.createCriteria();
		if (type == 1) {
			criteria.andPnameLike("%" + key + "%");
		} else if (type == 2) {
			// 根据项目经理的名称查对应的id
			List<Employee> list = employeeService.listByName(key);
			List<Integer> empFks = new ArrayList<>();
			if (list.size() > 0) {
				for (Employee employee : list) {
					empFks.add(employee.getEid());
				}
				criteria.andEmpFkIn(empFks);
			} else {
				// 如果集合没有内容，就设置一个0，防止出错
				empFks.add(0);
				criteria.andEmpFkIn(empFks);
			}
		}
		return projectMapper.selectByExample(example);
	}

	@Override
	public boolean save(Project project) {
		int insertSelective = projectMapper.insertSelective(project);
		if(insertSelective>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean removeAll(List<Integer> ids) {
		ProjectExample example = new ProjectExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidIn(ids);
		int deleteByExample = projectMapper.deleteByExample(example);
		if(deleteByExample>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean removeOne(int pid) {
		int deleteByPrimaryKey = projectMapper.deleteByPrimaryKey(pid);
		if(deleteByPrimaryKey>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Project getById(int pid) {
		Project project = projectMapper.selectByPrimaryKey(pid);
		return project;
	}

	@Override
	public boolean update(Project project) {
		int result = projectMapper.updateByPrimaryKeySelective(project);
		System.out.println(result);
		if(result>0) {
			return true;
		}else {
			return false;
		}
		
	}

}










