package com.java.springboot.EmployeeManagementSystem.service;

import java.util.List;

import com.java.springboot.EmployeeManagementSystem.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);
	List<Employee> getAllEmployees();
	Employee getEmployeeByID(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
	
}
