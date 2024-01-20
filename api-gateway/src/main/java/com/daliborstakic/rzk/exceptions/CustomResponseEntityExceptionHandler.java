package com.daliborstakic.rzk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import feign.FeignException;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(FeignException.class)
	protected ResponseEntity<FeignErrorEntity> handleFeignException(FeignException ex, WebRequest request) {
		FeignErrorEntity sd = new FeignErrorEntity(ex.status(), ex.contentUTF8());
		return new ResponseEntity<FeignErrorEntity>(sd, HttpStatus.valueOf(ex.status()));
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException ex) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
