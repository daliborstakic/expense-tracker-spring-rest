package com.daliborstakic.rzk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExchangeRateDoesntExistException extends Exception {
	private static final long serialVersionUID = 1L;
	private Object invalidData;

	public ExchangeRateDoesntExistException(String message, Object invalidData) {
		super(message);
		this.invalidData = invalidData;
	}

	public Object getInvalidData() {
		return invalidData;
	}

	public void setInvalidData(Object invalidData) {
		this.invalidData = invalidData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
