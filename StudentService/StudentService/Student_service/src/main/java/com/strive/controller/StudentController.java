package com.strive.controller;

import com.strive.dto.StudentDto;
import com.strive.service.StudentService;
import com.strive.exception.ResourceNotFoundException;
import com.strive.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/student", produces = {MediaType.APPLICATION_JSON_VALUE})
public class StudentController {

    @Autowired
    private StudentService studentService;

    ///.............................    CREATING STUDENT DETAILS   ........................///
    @PostMapping("/create")
    public ResponseEntity<StudentDto> saveStudent(@Validated @RequestBody StudentDto studentDto) 
    {
        StudentDto savedStudent = studentService.saveStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    ///.............................   GETTING STUDENT DETAILS    .........................///
    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents() 
    {
        List<StudentDto> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    ///............................   GETTING STUDENT BY ID   ............................///

    @GetMapping("/studentId/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable long studentId) 
    {
        StudentDto student = studentService.getStudentById(studentId);
        if (student != null) 
        {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Student not found with ID: " + studentId);
        }
    }

  ///.............................   DELETING STUDENT BY UUID    ............................///
    
    @DeleteMapping("/students/{studentId}")
	public void deleteStudentByStudentId(@PathVariable String studentId) 
	{
		studentService.deleteStudentByStudentId(studentId);
	}
    
    
    ///............................   UPDATING THE STUDENT DETAILS    ..................................///
    

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable long id, @Validated @RequestBody StudentDto studentDto) {
        StudentDto updatedStudent = studentService.updateStudent(id, studentDto);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Student not found with ID: " + id);
        }
    }
    
    ///............................  GETTING STUDENT DETAILS BY DISTRICT AND YEAR    ...........................///

    @GetMapping("/district/{district}/year/{year}")
    public ResponseEntity<List<StudentDto>> getStudentsByDistrictAndPassingYear(@PathVariable String district, @PathVariable String year) 
    {
        List<StudentDto> students = studentService.getStudentsByDistrictAndPassingYear(district, year);
        if (students.isEmpty()) 
        {
            throw new ResourceNotFoundException("No students found with district: " + district + " and year: " + year);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    
    ///..............................   GETTING STUDENT  DETAILS BY YEAR    ...............................///

    @GetMapping("/year/{passingYear}")
    public ResponseEntity<List<StudentDto>> getStudentByYear(@PathVariable String passingYear) 
    {
        List<StudentDto> students = studentService.getStudentsByYear(passingYear);
        if (students.isEmpty()) 
        {
            throw new ResourceNotFoundException("No students found with passing year: " + passingYear);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    
    ///............................   GETTING STUDENT DETAILS BY ITI - NAME    ................................///

    @GetMapping("/iti/{itiName}")
    public ResponseEntity<List<StudentDto>> getStudentsByItiName(@PathVariable String itiName) 
    {
        List<StudentDto> students = studentService.getStudentsByItiName(itiName);
        if (students.isEmpty()) 
        {
            throw new ResourceNotFoundException("No students found with ITI name: " + itiName);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    ///..............................    Handle other exceptions if necessary   ......................................///
    
    
    ///...........................   BAD-EXCEPTION-HANDLER   ..........................//
    
    
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException ex) 
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    
   ///...............................    RESOURCE-NOT-FOUND-EXCEPTION    .........................///
    
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) 
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}





	///................................................ TESTING POST MAPPING    ..............................///




	
	
	


