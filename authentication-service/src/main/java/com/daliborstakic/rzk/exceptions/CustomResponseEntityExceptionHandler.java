package com.daliborstakic.rzk.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import feign.FeignException;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(FeignException.class)
	protected ResponseEntity<FeignErrorEntity> handleFeignException(FeignException ex, WebRequest request) {
		FeignErrorEntity sd = new FeignErrorEntity(ex.status(), ex.contentUTF8());
		return new ResponseEntity<FeignErrorEntity>(sd, HttpStatus.valueOf(ex.status()));
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorMessage> handleIllegalArgumentException(IllegalArgumentException ex) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage("Missing parameters!"), HttpStatus.BAD_REQUEST);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ValidationErrorEntity sd = new ValidationErrorEntity("Total errors: " + ex.getErrorCount() + ". First error: "
				+ ex.getFieldErrors().get(0).getDefaultMessage());
		return new ResponseEntity<Object>(sd, HttpStatus.BAD_REQUEST);
	}
}
