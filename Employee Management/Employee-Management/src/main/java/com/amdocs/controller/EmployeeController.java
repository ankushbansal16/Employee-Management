package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.entity.Employee;
import com.amdocs.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService es;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Employee Application";
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return this.es.getAllEmployees();
	}
	
	@GetMapping("/employees/{empId}")
	public Employee getEmployeeById(@PathVariable int empId) {
		return this.es.getEmployeeById(empId);
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.es.addEmployee(employee);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployeeById(@PathVariable("id") int empId, @RequestBody Employee employee) {
		return es.updateEmployeeById(empId, employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployeeById(@PathVariable("id") int empId) {
		return es.deleteEmployeeById(empId);
	}
	
}
