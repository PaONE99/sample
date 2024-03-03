package com.first.auditing.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.auditing.dao.EmployeeRepo;
import com.first.auditing.dto.InputReq;
import com.first.auditing.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repository;
	public String saveEmployee(InputReq<Employee> req)
	{
		String currentUser = req.getLoggedinUser();
		req.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
		Employee employee = req.getEmployee();
		employee.setCreatedby(currentUser);
		repository.save(employee);
		return "employee Sucessfully";
		
	}
	public String updateEmployee(Long id, double salary,InputReq<Employee> req )
	{
		Employee employee = repository.findById(id).get();
		if (employee!=null)
		{
			employee.setSalary(salary);
			employee.setModifidby(req.getLoggedinUser());
			repository.saveAndFlush(employee);
			
		}
		else 
		{
			throw new RuntimeException("Employee not found with id :"+id);
		}
		return "Employee updated sucessfully";
	}
}
