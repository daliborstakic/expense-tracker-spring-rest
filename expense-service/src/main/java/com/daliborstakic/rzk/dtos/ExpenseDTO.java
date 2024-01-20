package com.daliborstakic.rzk.dtos;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ExpenseDTO {
	@NotBlank(message = "Description cannot be blank")
	@Size(max = 255, message = "Description must be at most 255 characters")
	private String description;

	@NotNull(message = "Amount cannot be null")
	private BigDecimal amount;

	@NotNull(message = "Currency cannot be null")
	private Integer currency;

	@NotNull(message = "Category cannot be null")
	private Integer category;

	@NotNull(message = "Date cannot be null")
	@Temporal(TemporalType.DATE)
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
