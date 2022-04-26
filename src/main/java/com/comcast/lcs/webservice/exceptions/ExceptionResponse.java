package com.comcast.lcs.webservice.exceptions;

import lombok.Builder;

import java.util.Date;


@Builder
public class ExceptionResponse {
	public Date timestamp;
	public String message;
	public String details;
	public String severity;
	public String fieldname;
	
	public ExceptionResponse(Date timestamp, String message, String details, String severity, String fieldname) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.severity = severity;
		this.fieldname = fieldname;
	}	 
	
	
}