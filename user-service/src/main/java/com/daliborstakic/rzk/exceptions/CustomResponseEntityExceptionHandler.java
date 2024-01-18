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

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails<String>> handleUserNotFoundException(UserNotFoundException ex,
			WebRequest request) {
		ErrorDetails<String> ed = new ErrorDetails<>(ex.getMessage(), ex.getUsername());
		return new ResponseEntity<ErrorDetails<String>>(ed, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails<String>> handleCategoryIsNonexistentException(UserAlreadyExistsException ex,
			WebRequest request) {
		ErrorDetails<String> ed = new ErrorDetails<>(ex.getMessage(), ex.getUsername());
		return new ResponseEntity<ErrorDetails<String>>(ed, HttpStatus.NOT_FOUND);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ValidationErrorEntity sd = new ValidationErrorEntity("Total errors: " + ex.getErrorCount() + ". First error: "
				+ ex.getFieldErrors().get(0).getDefaultMessage());
		return new ResponseEntity<Object>(sd, HttpStatus.BAD_REQUEST);
	}
}
