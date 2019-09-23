package com.ujiuye.crmpro.employee.service;

import java.util.List;

import com.ujiuye.crmpro.employee.pojo.Employee;

public interface EmployeeService {
	List<Employee> listByName(String name);
	List<Employee> listByPFK(int p_fk);
	List<Employee> list();
	List<Employee> getBydfk(int fk);
	Employee login(Employee employee);
	Employee getByName(String name);
}
