package com.daliborstakic.rzk.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseDTO {
	private String description;
	private BigDecimal amount;
	private Integer currency;
	private Integer category;
	private Date date;

	public ExpenseDTO(String description, BigDecimal amount, Integer currency, Integer category, Date date) {
		super();
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.category = category;
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getCurrency() {
		return currency;
	}

	public void setCurrency(Integer currency) {
		this.currency = currency;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
