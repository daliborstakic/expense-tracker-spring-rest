package com.daliborstakic.rzk.exceptions;

public class CurrencyNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private Integer idCurrency;

	public CurrencyNotFoundException(Integer idCurrency) {
		this.setIdCurrency(idCurrency);
	}

	public Integer getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(Integer idCurrency) {
		this.idCurrency = idCurrency;
	}
}
