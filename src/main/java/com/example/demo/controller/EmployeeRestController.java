package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import net.minidev.json.JSONObject;


@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(path="/employees", method=RequestMethod.GET)
//	public List<Employee> getAllEmployees(){
//		return employeeService.getAllEmployees();
//	}
	public ResponseEntity<JSONObject> getEmployees() {
		int recordTotals = 20;
		JSONObject json = new JSONObject();
		json.put("draw", 1);
		json.put("recordsTotal", recordTotals);
		json.put("recordsFiltered", recordTotals);
		List<Object> arrData = new ArrayList<>();
		for(int i = 0; i <recordTotals; i++) {
			arrData.add(Arrays.asList("1", "hien", "pham", "hienhack@gmail.com", "039694", "1"));
		}
		json.put("data", arrData);
		ResponseEntity<JSONObject> response = new ResponseEntity<JSONObject>(json, HttpStatus.OK);
		return response;
	}
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Optional<Employee> getEmployeeById(@PathVariable("id") long id){
		return employeeService.getEmployeeById(id);
	}

}
