package com.amdocs.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.entity.Employee;
import com.amdocs.repo.EmployeeRepo;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return employeeRepo.findById(empId).get();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		employeeRepo.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployeeById(int id, Employee employee) {
		Optional<Employee> emp = employeeRepo.findById(id);
		
		if(emp.isPresent()) {
			Employee existingEmployee = emp.get();
			
			if(Objects.nonNull(employee.getEmpFirstName()) && !"".equalsIgnoreCase(employee.getEmpFirstName())) {
				existingEmployee.setEmpFirstName(employee.getEmpFirstName());
			}
			
			if(Objects.nonNull(employee.getEmpLastName()) && !"".equalsIgnoreCase(employee.getEmpLastName())) {
				existingEmployee.setEmpLastName(employee.getEmpLastName());
			}
			
			if(Objects.nonNull(employee.getEmpEmail()) && !"".equalsIgnoreCase(employee.getEmpEmail())) {
				existingEmployee.setEmpEmail(employee.getEmpEmail());
			}
			
			return employeeRepo.save(existingEmployee);
		}
		
		return null;
	}

	@Override
	public String deleteEmployeeById(int empId) {
		if(employeeRepo.findById(empId).isPresent()) {
			employeeRepo.deleteById(empId);
			return "Employee Deleted Successfully!";
		}
		return "No such employee in the database";
	}
	
}

