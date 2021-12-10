package com.java.springboot.EmployeeManagementSystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.springboot.EmployeeManagementSystem.exceptions.ResourceNotFoundException;
import com.java.springboot.EmployeeManagementSystem.model.Employee;
import com.java.springboot.EmployeeManagementSystem.repository.EmployeeRepository;
import com.java.springboot.EmployeeManagementSystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}



	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeByID(long id) {
		// TODO Auto-generated method stub
		
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		
		Employee employeeExisting = employeeRepository.findById(id).orElseThrow(() -> 
		
			new ResourceNotFoundException("Employee", "id", id));
		
		employeeExisting.setFname(employee.getFname());
		employeeExisting.setSname(employee.getSname());
		employeeExisting.setEmail(employee.getEmail());
		
		employeeRepository.save(employeeExisting);
		
		return employeeExisting;
	}


	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		
		employeeRepository.findById(id).orElseThrow(() -> 
		
			new ResourceNotFoundException("Employee", "id", id)
				
		);
		
		employeeRepository.deleteById(id);
	}

}
