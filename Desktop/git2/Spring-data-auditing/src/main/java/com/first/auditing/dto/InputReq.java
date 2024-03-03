package com.first.auditing.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputReq<T> {
	@JsonProperty(value = "userId",required = true)
	private String loggedinUser;
	private String timeZone; // to get time zone 
	private T employee; // to pass the json object generic 
}
