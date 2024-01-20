package com.daliborstakic.rzk.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public class ExchangeRateDTO {
	@NotNull(message = "From currency cannot be null!")
	private Integer currency1;

	@NotNull(message = "To currency cannot be null!")
	private Integer currency2;

	@NotNull(message = "Rate cannot be null!")
	private BigDecimal rate;

	public ExchangeRateDTO(Integer currency1, Integer currency2, BigDecimal rate) {
		super();
		this.currency1 = currency1;
		this.currency2 = currency2;
		this.rate = rate;
	}

	public Integer getCurrency1() {
		return currency1;
	}

	public void setCurrency1(Integer currency1) {
		this.currency1 = currency1;
	}

	public Integer getCurrency2() {
		return currency2;
	}

	public void setCurrency2(Integer currency2) {
		this.currency2 = currency2;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
}
