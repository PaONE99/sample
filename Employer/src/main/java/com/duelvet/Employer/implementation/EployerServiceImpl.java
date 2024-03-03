package com.duelvet.Employer.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duelvet.Employer.Dto.EmployerDto;
import com.duelvet.Employer.entity.Employer;
import com.duelvet.Employer.repository.EmployerRepository;
import com.duelvet.Employer.service.EmployerService;
@Service
public  class EployerServiceImpl implements EmployerService {
	@Autowired
	private EmployerRepository employerrepository;

	@Override
	public EmployerDto saveemployer(EmployerDto employedto) {
		// Convert EmployerDto to Employer entity

				Employer employer=new Employer();
			    BeanUtils.copyProperties(employedto, employer);
			    // Save the entity to the database using EmployerRepository
			    Employer savedEmployer = employerrepository.save(employer);
			    // Convert the saved entity back to DTO and return
			    EmployerDto savedEmployerDto = new EmployerDto();
			    BeanUtils.copyProperties(savedEmployer, savedEmployerDto);
			    return savedEmployerDto;			
	}

	@Override
	public List<EmployerDto> getAllEmployes() {
     // Retrieve all Employer from the database using EmployerRepository
		
        List<Employer> employe = employerrepository.findAll();

        // Convert the entities to DTOs
        
        List<EmployerDto> employeDTOs = new ArrayList<>();
        for (Employer employee : employe) {
        	EmployerDto employeDTO = new EmployerDto();
            BeanUtils.copyProperties(employee, employeDTO);
            employeDTOs.add(employeDTO);
        }
        return employeDTOs;	
	}

	@Override
	public EmployerDto getEmployerById(long id) {
// Retrieve the employe with the given id from the database using EmployerRepository
		
        Optional<Employer> optionalemploye = employerrepository.findById(id);

        // If the employe is found, convert the entity to a DTO and return
        
        if (optionalemploye.isPresent()) 
        {
        	Employer employe = optionalemploye.get();
        	EmployerDto employeDTO = new EmployerDto();
            BeanUtils.copyProperties(employe, employeDTO);
            return employeDTO;
        }

        // If the employe is not found
        return null;
	}

	@Override
	public EmployerDto updateEmployer(long id, EmployerDto employedto) {
		Optional<Employer> optionalEmployer = employerrepository.findById(id);
        if (optionalEmployer.isPresent()) {
            Employer existingEmployer = optionalEmployer.get();
            BeanUtils.copyProperties(employedto, existingEmployer);
            Employer updatedEmployer = employerrepository.save(existingEmployer);
            EmployerDto updatedEmployerDto = new EmployerDto();
            BeanUtils.copyProperties(updatedEmployer, updatedEmployerDto);
            return updatedEmployerDto;
        }
        return null; 
        // or throw an exception indicating the employer with the given id was not found
	}

	@Override
	public void deleteEmployer(long id) {
        employerrepository.deleteById(id);
		
	}
}
