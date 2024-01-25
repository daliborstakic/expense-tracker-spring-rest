package com.daliborstakic.rzk.pojos;

public class Currency {
	private Integer idCurrency;
	private String currencyName;
	private String currencyCode;

	public Currency(Integer idCurrency, String currencyName, String currencyCode) {
		super();
		this.idCurrency = idCurrency;
		this.currencyName = currencyName;
		this.currencyCode = currencyCode;
	}

	public Integer getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(Integer idCurrency) {
		this.idCurrency = idCurrency;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
