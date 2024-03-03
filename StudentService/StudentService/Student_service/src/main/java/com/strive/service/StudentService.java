	package com.strive.service;
	
	import java.util.List;


import com.strive.dto.StudentDto;
	

	public interface StudentService {
		
	        ///  CREATION OF STUDENT   ///
		
		StudentDto saveStudent(StudentDto studentdtO);
		
		
		   ///   GET ALL STUDENT DETAILS   ///
		
	    List<StudentDto> getAllStudents();
	    
	    
	    ///   GET STUDENT BY ID   ///
	    
	    StudentDto getStudentById(long id);
	    

	    
	    ///   DELETE STUDENT-ID BY USING UUID   //
	    
	    void deleteStudentByStudentId(String studentId);
	   
	    
	    
	    
	    ///   UPDATING THE STUDENT DETAILS   ///
	    
	    StudentDto updateStudent(long id, StudentDto studentDto);
	
	    
	    ///   GETTING STUDENT DETAILS BY USING STATE AND YEAR    ///

	    List<StudentDto> getStudentsByDistrictAndPassingYear(String district, String passingYear);
	    
	    
	    ///   GET STUDENT DETAILS BY YEAR    ///
	    
		List<StudentDto> getStudentsByYear(String passingyear);
		
		
		///   GET STUDENT DETAILS BY ITI   ///
		
		List<StudentDto> getStudentsByItiName(String itiName);
		
		///  
		
	}
