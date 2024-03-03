package com.strive.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 50, message = "Field name must be between 3 and 50 characters")
    private String name;
    
    @Column(name = "aadhar_no", unique = true)
    @Pattern(regexp = "\\d{12}", message = "Contact number must be 10 digits")
    @NotBlank(message = "Aadhar number is mandatory")
    private String aadharNo;
    
    @NotNull(message = "Date of birth is mandatory")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "mm/dd/yyy")
    private LocalDate dob;
    
    @NotBlank(message = "Highest qualification is mandatory")
    private String highestQualification;
    
    @NotBlank(message = "Passing year is mandatory")
    private String passingYear;
    
    @NotBlank(message = "Specialization is mandatory")
    private String specialization;
    
    @NotBlank(message = "District is mandatory")
    private String district;
    
    @NotBlank(message = "ITI IS MANDATORY")
    private String itiName;
    
    @NotBlank(message = "Admission month and year is mandatory")
    private String admissionMonthAndYear;
    
    @Column(name = "course_duration_1yr_or_2Yr")
    @NotBlank(message = "Course duration is mandatory")
    private String courseDuration;
    
    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    @NotNull(message = "Contact number is mandatory")
    private String primaryContactNumber;
    
    @NotBlank(message = "Trade is mandatory")
    private String trade;
    
    private String studentId;
    
    
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	
	 @CreatedBy
	 @Column(updatable = false)
    private String createdBy;
	 
	 @LastModifiedBy
    private String updatedBy; 

	 // Remarks
    @Size(max = 255, message = "Remarks must be less than or equal to 255 characters")
	private String remarks;
	

    
    
   
}