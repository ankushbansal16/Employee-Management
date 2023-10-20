package com.amdocs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
