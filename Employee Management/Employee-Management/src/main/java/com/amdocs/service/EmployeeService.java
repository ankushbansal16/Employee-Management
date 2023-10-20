package com.amdocs.service;

import java.util.List;

import com.amdocs.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int empId);
	
	public Employee addEmployee(Employee employee);
	
	public Employee updateEmployeeById(int id, Employee employee);
	
	public String deleteEmployeeById(int empId);
}
