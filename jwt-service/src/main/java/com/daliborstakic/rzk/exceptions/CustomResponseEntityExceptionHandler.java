package com.daliborstakic.rzk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.jsonwebtoken.MalformedJwtException;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(MalformedJwtException.class)
	protected ResponseEntity<ErrorDetails> handleFeignException(MalformedJwtException ex, WebRequest request) {
		Throwable cause = ex.getCause();
		String causeData = null;

		if (cause != null)
			causeData = cause.getMessage();

		ErrorDetails ed = new ErrorDetails(causeData);

		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
}
