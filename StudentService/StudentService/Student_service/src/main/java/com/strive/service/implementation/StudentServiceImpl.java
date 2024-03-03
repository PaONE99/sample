package com.strive.service.implementation;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strive.dto.StudentDto;
import com.strive.entity.Student;
import com.strive.repository.StudentRepository;
import com.strive.service.StudentService;




@Service
public class StudentServiceImpl implements StudentService 
{
	@Autowired
	private StudentRepository studentrepository;
	
	
	///.................(POST MAPPING) POSTING THE STUDENT DETAILS   ...................///
	
	@Override
	public StudentDto saveStudent(StudentDto studentDto) 
	{
		
		String studentId = UUID.randomUUID().toString();
		studentDto.setStudentId(studentId);
		
	    // Convert StudentDto to Student entity
	    Student student = new Student();
	    BeanUtils.copyProperties(studentDto, student);

	    // Save the entity to the database using StudentRepository
	    Student savedStudent = studentrepository.save(student);

	    // Convert the saved entity back to DTO and return
	    StudentDto savedStudentDto = new StudentDto();
	    BeanUtils.copyProperties(savedStudent, savedStudentDto);
	    return savedStudentDto;
	}
	    
	
	   ///..................(GET MAPPING) GET ALL STUDENT DETAILS .................///

	@Override
	public List<StudentDto> getAllStudents() 
	{
		 // Retrieve all students from the database using StudentRepository
        List<Student> students = studentrepository.findAll();

        // Convert the entities to DTOs
        List<StudentDto> studentDTOs = new ArrayList<>();
        for (Student student : students) {
            StudentDto studentDTO = new StudentDto();
            BeanUtils.copyProperties(student, studentDTO);
            studentDTOs.add(studentDTO);
        }
        return studentDTOs;
		
	}
	
	    ///.................... (GET MAPPING) GET STUDENT BY ID ......................./// 

	@Override
	public StudentDto getStudentById(long id) 
	{
		// Retrieve the student with the given id from the database using StudentRepository
        Optional<Student> optionalStudent = studentrepository.findById(id);

        // If the student is found, convert the entity to a DTO and return
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            StudentDto studentDTO = new StudentDto();
            BeanUtils.copyProperties(student, studentDTO);
            return studentDTO;
        }

        // If the student is not found, return null
        return null;
    }
	
	
	
	///   .......................   (GET MAPPING) GET STUDENT DETAILS BY YEAR   ................................   ///
	 @Override
	    public List<StudentDto> getStudentsByYear(String passingyear) 
	 {
	        List<Student> students = studentrepository.findByPassingYear(passingyear);
	        return students.stream()
	                .map(this::convertToDto2)
	                .collect(Collectors.toList());
	  }

	    private StudentDto convertToDto2(Student student) 
	    {
	        StudentDto dto = new StudentDto();
	        BeanUtils.copyProperties(student, dto);
	        return dto;
	    }
	    
	    
	 ///.......................   (GET MAPPING) GET STUDENT DETAILS BY ITI   ........................///   
	
	    @Override
	    public List<StudentDto> getStudentsByItiName(String itiName)
	    { 
	    	List<Student> students = studentrepository.findByitiName(itiName);
	    	return students.stream()
	    			.map(this::convertToDto3)
	                .collect(Collectors.toList());
	    }
	    private StudentDto convertToDto3(Student student) 
	    {
	        StudentDto dto = new StudentDto();
	        BeanUtils.copyProperties(student, dto);
	        return dto;
	    }
	    
	    

	///.....................  (DELETE MAPPING) DELETE STUDENT BY ID   .........................///
	    @Override
	    public void deleteStudentByStudentId(String studentId) 
	    {
	        Optional<Student> studentOptional = studentrepository.findByStudentId(studentId);
	        if (studentOptional.isPresent()) 
	        {
	            Student student = studentOptional.get();
	            studentrepository.deleteById(student.getId());
	        } else 
	        {
	            throw new IllegalArgumentException("Student with studentId " + studentId + " not found");
	        }
	    }
	
	/// .....................  (PUT MAPPING) UPDATING THE STUDENT DETAILS   ................///
	@Override
    public StudentDto updateStudent(long id, StudentDto studentDto) {
        // Check if a student with the provided ID exists
        Optional<Student> existingStudentOptional = studentrepository.findById(id);
        if (!existingStudentOptional.isPresent()) {
            // If the student does not exist, return null or throw an exception as per your error handling strategy
            return null; // Or throw new ResourceNotFoundException("Student not found with id: " + id);
        }
        
        Student existingStudent = existingStudentOptional.get();
        
        // Updating only modifiable fields, ignoring ID, createdAt, etc. if they exist
        existingStudent.setName(studentDto.getName());
        existingStudent.setAadharNo(studentDto.getAadharNo());
        existingStudent.setDob(studentDto.getDob());
        existingStudent.setHighestQualification(studentDto.getHighestQualification());
        existingStudent.setPassingYear(studentDto.getPassingYear());
        existingStudent.setSpecialization(studentDto.getSpecialization());
        existingStudent.setDistrict(studentDto.getDistrict());
        existingStudent.setItiName(studentDto.getItiName());
        existingStudent.setAdmissionMonthAndYear(studentDto.getAdmissionMonthAndYear());
        existingStudent.setCourseDuration(studentDto.getCourseDuration());
        existingStudent.setPrimaryContactNumber(studentDto.getPrimaryContactNumber());
        existingStudent.setTrade(studentDto.getTrade());
        existingStudent.setCreatedBy(studentDto.getCreatedBy()); // Consider if this should actually be updated here
        existingStudent.setUpdatedBy(studentDto.getUpdatedBy()); // Set this to the current user/system updating the record
        existingStudent.setRemarks(studentDto.getRemarks());
        
        // Save the updated student
        Student updatedStudent = studentrepository.save(existingStudent);
        
        // Convert the updated student to DTO
        StudentDto updatedStudentDto = new StudentDto();
        BeanUtils.copyProperties(updatedStudent, updatedStudentDto);
        
        return updatedStudentDto;
    }
	
	///   ..........................GET STUDENT BY DISTRICT AND YEAR.....................................   ///
	
	 @Override
	    public List<StudentDto> getStudentsByDistrictAndPassingYear(String district, String passingYear) {
	        List<Student> students = studentrepository.findByDistrictAndPassingYear(district, passingYear);
	        return students.stream()
	                .map(this::convertToDto)
	                .collect(Collectors.toList());
	    }

	    private StudentDto convertToDto(Student student) 
	    {
	        StudentDto dto = new StudentDto();
	        BeanUtils.copyProperties(student, dto);
	        return dto;
	    }

		
}
	
	
	
	

	

	
