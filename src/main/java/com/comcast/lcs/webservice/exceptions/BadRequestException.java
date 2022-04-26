package com.comcast.lcs.webservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class BadRequestException extends RuntimeException{
	public BadRequestException(String fieldname) {
		super(fieldname);
	}
}
