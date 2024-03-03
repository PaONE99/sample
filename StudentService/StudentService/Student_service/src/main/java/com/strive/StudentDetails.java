package com.strive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StudentDetails {

	public static void main(String[] args) 
	{
		SpringApplication.run(StudentDetails.class, args);
		System.out.println("Student Service Starting");
	}

}
