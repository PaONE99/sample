package com.strive.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.strive.entity.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	
	///   ...................CREATING METHOD FOR DISTRICT AND PASSING YEAR................   ///
	
	List<Student> findByDistrictAndPassingYear(String district, String year);
	
	

	///   .....................CREATE METHOD FOR GETTING STUDENT DETAILS BY YEAR.......................   ///
	
				List<Student> findByPassingYear(String passingyear);
				
				
	///   .....................CREATE METHOD FOR GETTING STUDENT DETAILS BY ITI......................   ///
	
				List<Student> findByitiName(String itiName);
				
	///   ....................FIND THE STUDENT-ID FOR UUID.........................   ///
				
				Optional<Student> findByStudentId(String studentId);
				
}
