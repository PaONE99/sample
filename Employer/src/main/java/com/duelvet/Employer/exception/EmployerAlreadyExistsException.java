package com.duelvet.Employer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)

public class EmployerAlreadyExistsException extends RuntimeException {
	 public EmployerAlreadyExistsException (String message) {
	        super(message);
	    }
}
