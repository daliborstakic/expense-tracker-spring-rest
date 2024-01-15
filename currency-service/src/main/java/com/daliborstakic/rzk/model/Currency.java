package com.daliborstakic.rzk.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

/**
 * The persistent class for the Currency database table.
 * 
 */
@Entity
@NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c")
public class Currency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurrency;

	private String currencyCode;

	private String currencyName;

	// bi-directional many-to-one association to ExchangeRate
	@JsonIgnore
	@OneToMany(mappedBy = "currency1")
	private List<ExchangeRate> exchangeRates1;

	// bi-directional many-to-one association to ExchangeRate
	@JsonIgnore
	@OneToMany(mappedBy = "currency2")
	private List<ExchangeRate> exchangeRates2;

	public Currency() {
	}

	public int getIdCurrency() {
		return this.idCurrency;
	}

	public void setIdCurrency(int idCurrency) {
		this.idCurrency = idCurrency;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return this.currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public List<ExchangeRate> getExchangeRates1() {
		return this.exchangeRates1;
	}

	public void setExchangeRates1(List<ExchangeRate> exchangeRates1) {
		this.exchangeRates1 = exchangeRates1;
	}

	public ExchangeRate addExchangeRates1(ExchangeRate exchangeRates1) {
		getExchangeRates1().add(exchangeRates1);
		exchangeRates1.setCurrency1(this);

		return exchangeRates1;
	}

	public ExchangeRate removeExchangeRates1(ExchangeRate exchangeRates1) {
		getExchangeRates1().remove(exchangeRates1);
		exchangeRates1.setCurrency1(null);

		return exchangeRates1;
	}

	public List<ExchangeRate> getExchangeRates2() {
		return this.exchangeRates2;
	}

	public void setExchangeRates2(List<ExchangeRate> exchangeRates2) {
		this.exchangeRates2 = exchangeRates2;
	}

	public ExchangeRate addExchangeRates2(ExchangeRate exchangeRates2) {
		getExchangeRates2().add(exchangeRates2);
		exchangeRates2.setCurrency2(this);

		return exchangeRates2;
	}

	public ExchangeRate removeExchangeRates2(ExchangeRate exchangeRates2) {
		getExchangeRates2().remove(exchangeRates2);
		exchangeRates2.setCurrency2(null);

		return exchangeRates2;
	}

}