package com.duelvet.Employer.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployerException {
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String,String>resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldname=((FieldError)error).getField();
			String message =error.getDefaultMessage();
			resp.put(fieldname, message);
		});
		return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
	}

    


}
