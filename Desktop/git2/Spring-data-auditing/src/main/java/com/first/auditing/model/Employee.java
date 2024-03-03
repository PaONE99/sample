package com.first.auditing.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Employee_TB")
public class Employee {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "mm/dd/yyy")
	private Date dob;
	private String dept;
	private double salary;
	
	//audit
	@CreatedDate
	private Date createDate;
	@LastModifiedDate
	private Date lastmodificationDate;
	@CreatedBy
	private String createdby;
	@LastModifiedBy
	private String modifidby;
	
}
