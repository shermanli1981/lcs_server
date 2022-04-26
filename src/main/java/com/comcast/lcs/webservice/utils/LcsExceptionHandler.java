package com.comcast.lcs.webservice.utils;


import com.comcast.lcs.webservice.exceptions.BadRequestException;
import com.comcast.lcs.webservice.exceptions.ExceptionResponse;
import com.comcast.lcs.webservice.exceptions.InputBodyNotFoundException;
import com.comcast.lcs.webservice.exceptions.StringsNotFoundOrEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController
public class LcsExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false), "ERROR", null);
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InputBodyNotFoundException.class)
	public final ResponseEntity<Object> handleInputBodyNotFoundException(InputBodyNotFoundException exception, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false), "ERROR", null);
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(StringsNotFoundOrEmptyException.class)
	public final ResponseEntity<Object> handleStringsNotFoundOrEmptyException(StringsNotFoundOrEmptyException exception, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false), "ERROR", null);
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<Object> handleBadRequestException(BadRequestException exception, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
				request.getDescription(false), "ERROR", exception.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
