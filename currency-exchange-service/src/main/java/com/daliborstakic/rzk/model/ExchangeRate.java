package com.daliborstakic.rzk.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotNull;

/**
 * The persistent class for the ExchangeRate database table.
 * 
 */
@Entity
@NamedQuery(name = "ExchangeRate.findAll", query = "SELECT e FROM ExchangeRate e")
public class ExchangeRate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExchangeRate;

	@NotNull(message = "Rate cannot be null!")
	private BigDecimal rate;

	// bi-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumn(name = "Currency_fromTo")
	private Currency currency1;

	// bi-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumn(name = "Currency_toCurrency")
	private Currency currency2;

	public ExchangeRate() {
	}

	public int getIdExchangeRate() {
		return this.idExchangeRate;
	}

	public void setIdExchangeRate(int idExchangeRate) {
		this.idExchangeRate = idExchangeRate;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Currency getCurrency1() {
		return this.currency1;
	}

	public void setCurrency1(Currency currency1) {
		this.currency1 = currency1;
	}

	public Currency getCurrency2() {
		return this.currency2;
	}

	public void setCurrency2(Currency currency2) {
		this.currency2 = currency2;
	}
}