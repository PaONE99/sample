package com.first.auditing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class SpringDataAuditingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataAuditingApplication.class, args);
	}

}
