package com.ujiuye.crmpro.task.service;

import java.util.List;
import org.apache.tools.ant.taskdefs.EchoXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ujiuye.crmpro.task.mapper.TaskMapper;
import com.ujiuye.crmpro.task.pojo.Task;
import com.ujiuye.crmpro.task.pojo.TaskExample;
import com.ujiuye.crmpro.task.pojo.TaskExample.Criteria;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskMapper taskMapper;

	@Override
	public List<Task> list(int type,String key) {

		return taskMapper.selectByExample(new TaskExample());
	}

	@Override
	public List<Task> listByEmpFk(int emp_fk,int type,String key) {
		TaskExample taskExample = new TaskExample();
		Criteria criteria = taskExample.createCriteria();
		criteria.andEmpFk2EqualTo(emp_fk);	//fk2ÊÇÖ´ÐÐÕß
		return taskMapper.selectByExample(taskExample);
	}

	@Override
	public Task getById(int id) {

		return taskMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean save(Task task) {
		if (taskMapper.insert(task) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Task task) {

		if (taskMapper.updateByPrimaryKeySelective(task) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(int id) {
		int deleteByPrimaryKey = taskMapper.deleteByPrimaryKey(id);
		if (deleteByPrimaryKey > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(List<Integer> ids) {
		TaskExample taskExample = new TaskExample();
		Criteria criteria = taskExample.createCriteria();
		criteria.andIdIn(ids);
		if (taskMapper.deleteByExample(taskExample) > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public List getByfunFk(int funFk) {
		TaskExample taskExample = new TaskExample();
		Criteria criteria = taskExample.createCriteria();
		criteria.andFunFkEqualTo(funFk);
		List<Task> list = taskMapper.selectByExample(taskExample);
		return list;
	}

}














