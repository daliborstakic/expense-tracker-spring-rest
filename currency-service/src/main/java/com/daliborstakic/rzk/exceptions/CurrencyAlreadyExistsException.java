package com.daliborstakic.rzk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CurrencyAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	private String currencyCode;

	public CurrencyAlreadyExistsException(String message, String currencyCode) {
		super(message);
		this.currencyCode = currencyCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
