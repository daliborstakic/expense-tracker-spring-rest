package com.daliborstakic.rzk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.daliborstakic.rzk.dtos.ExchangeRateDTO;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExchangeRateAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	private ExchangeRateDTO exchangeRate;

	public ExchangeRateAlreadyExistsException(String message, ExchangeRateDTO exchangeRate) {
		super(message);
		this.exchangeRate = exchangeRate;
	}

	public ExchangeRateDTO getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(ExchangeRateDTO exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}
