package com.duelvet.Employer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duelvet.Employer.entity.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {



}
