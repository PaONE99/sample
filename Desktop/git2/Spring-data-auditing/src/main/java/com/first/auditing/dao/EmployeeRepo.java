package com.first.auditing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.auditing.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
