package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;


@Repository("employeeRepository")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{
	Page<Employee> findAll(Pageable pageable);
}
