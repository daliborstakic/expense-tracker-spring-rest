package com.daliborstakic.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;

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

	private String rate;

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

	public String getRate() {
		return this.rate;
	}

	public void setRate(String rate) {
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