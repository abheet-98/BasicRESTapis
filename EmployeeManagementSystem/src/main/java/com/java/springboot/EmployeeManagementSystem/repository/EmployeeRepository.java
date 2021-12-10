package com.java.springboot.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.springboot.EmployeeManagementSystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	

}
