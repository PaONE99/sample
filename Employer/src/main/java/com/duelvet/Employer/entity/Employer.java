package com.duelvet.Employer.entity;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;


	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@EntityListeners(AuditingEntityListener.class)
public class Employer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long id;
	
    @NotBlank(message = "Employer name is required")
    @Size(min = 2, max = 100, message = "Employer name must be between 2 and 100 characters")
	private String employerName;
	
    @NotBlank(message = "Website URL is required")
	private String website;
	
    // Contact person's name
	private String contactName;
	
	// Contact number
//    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
	private String contactNumber;
	
    @NotBlank(message = "Email ID is required")
    @Email(message = "Invalid email format")
    private String emailId;
	
    // Sector domain
	private String sectorDomain;
	
    @NotBlank(message = "District is required")
	private String district;
	
    @NotBlank(message = "State is required")
	private String state;
	
	@NotBlank(message="nearest city name is Mandatory")
	private String nearestCityName;
	
    @Positive(message = "Pincode must be a positive number")
	private int pincode; 
	
    //Latitude
    private int lat;
    
    // Longitude
	private int lon;
	
    // OJT placement
	private String ojtPlacement;
	
	 // Number of students OJT can accommodate
    @PositiveOrZero(message = "Number of students must be a positive or zero")
    private int noStudentsOjtCanBeAccommodated;
    
    // Stipend
    @PositiveOrZero(message = "Stipend must be a positive or zero")
    private float stipend;
    
    // Program name
	private String programName;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
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


