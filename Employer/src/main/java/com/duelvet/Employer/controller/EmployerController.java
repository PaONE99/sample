package com.duelvet.Employer.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duelvet.Employer.Dto.EmployerDto;
import com.duelvet.Employer.service.EmployerService;

import jakarta.validation.Valid;

@RestController
//Base path for all endpoints in this controller
@RequestMapping(path="/employer",produces = {MediaType.APPLICATION_JSON_VALUE})
public class EmployerController {
	@Autowired
	private EmployerService employerservice;
	
	@PostMapping("/create")    
	// CREATE operation: Create a new employer
	
	public ResponseEntity<EmployerDto>saveEmploye(@Valid @RequestBody EmployerDto employerdto)
	{
		EmployerDto saveemploye = employerservice.saveemployer(employerdto);
		return new ResponseEntity<>(saveemploye,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")  
	// READ operation: Get all employers
	
	 public ResponseEntity<List<EmployerDto>> getAllStudents()
	{
        List<EmployerDto> employe = employerservice.getAllEmployes();
        return new ResponseEntity<>(employe, HttpStatus.OK);
    }
	@GetMapping("/employer/{employeId}") 
	
	// READ operation: Get an employer by ID
	
	 public ResponseEntity<EmployerDto> getStudentById(@PathVariable long employeId) 
	{
		EmployerDto student = employerservice.getEmployerById(employeId);
        if (student != null)
        {
            return new ResponseEntity<>(student, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	/// UPDATING THE employer DETAILS BY ID .
    
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployerDto> updateEmploye(@PathVariable long id, @Validated @RequestBody EmployerDto employerDto) {
    	EmployerDto updateEmploye = employerservice.updateEmployer(id, employerDto);
        if (updateEmploye != null) {
            return new ResponseEntity<>(updateEmploye, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /// DELETE THE EMPLOYER DETAILS BY STUDENT ID   ..///
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployeById(@PathVariable long id) 
    {
    	employerservice.deleteEmployer(id);
        return ResponseEntity.ok().build();
    }
}
