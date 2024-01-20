package com.daliborstakic.rzk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CurrencyNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private Integer idCurrency;

	public CurrencyNotFoundException(String message, Integer invalidData) {
		super(message);
		this.setIdCurrency(invalidData);
	}

	public Integer getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(Integer idCurrency) {
		this.idCurrency = idCurrency;
	}
}
