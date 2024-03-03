package com.duelvet.Employer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duelvet.Employer.Dto.EmployerDto;
@Service
public interface EmployerService {
    // Method to save a new employer
    EmployerDto saveemployer(EmployerDto employedto);

    // Method to retrieve all employers
    List<EmployerDto> getAllEmployes();

    // Method to retrieve an employer by ID
    EmployerDto getEmployerById(long id);

    // Method to update an existing employer
    EmployerDto updateEmployer(long id, EmployerDto employedto);

    // Method to delete an employer by ID
    void deleteEmployer(long id);
	
	


}
