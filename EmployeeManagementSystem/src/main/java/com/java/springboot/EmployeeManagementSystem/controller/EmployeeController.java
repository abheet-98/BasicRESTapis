package com.java.springboot.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.EmployeeManagementSystem.model.Employee;
import com.java.springboot.EmployeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//Build create Employee REST api
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(emp),HttpStatus.CREATED);
	}
	
	//Build get all employees REST api
	@GetMapping()
	public List<Employee> getEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//Build get employee by id REST api
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeByID(employeeId),HttpStatus.OK);
	}
	
	//Build updateEmployee REST api
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee emp){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(emp, employeeId),HttpStatus.OK);
		
	}
	
	//Build deleteEmployee REST api
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){
		
		employeeService.deleteEmployee(employeeId);
		
		return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
		
	}
	
}
