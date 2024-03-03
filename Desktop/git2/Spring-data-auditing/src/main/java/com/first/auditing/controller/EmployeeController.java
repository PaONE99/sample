package com.first.auditing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.auditing.dto.InputReq;
import com.first.auditing.model.Employee;
import com.first.auditing.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
private EmployeeService service;
	
	@PostMapping("/addEmployee")
	public String  saveEmployee(@RequestBody InputReq<Employee>req)
	{
		return service.saveEmployee(req);
		
	}
	
	@PutMapping("/updateEmployee/{id}/{salary}")
	public String  updateEmployeesalary(@PathVariable Long id ,@PathVariable double salary,@RequestBody InputReq<Employee>req)
	{
		return  service.updateEmployee(id, salary, req);
		
	}
	
}
