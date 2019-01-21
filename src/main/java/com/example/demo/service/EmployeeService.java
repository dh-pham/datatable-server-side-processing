package com.example.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Employee;


public interface EmployeeService {
	
	public Page<Employee> getAllEmployees(int page, int size);
	public Optional<Employee> getEmployeeById(long id);
	
}
