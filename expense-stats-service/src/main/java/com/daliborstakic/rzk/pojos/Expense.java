package com.daliborstakic.rzk.pojos;

public class Expense {
	private Integer idExpense;
	private Category category;
	private Currency currency;
	private double amount;
	private String description;

	public Expense(Integer idExpense, Category category, Currency currency, double amount, String description) {
		super();
		this.idExpense = idExpense;
		this.category = category;
		this.currency = currency;
		this.amount = amount;
		this.description = description;
	}

	public Integer getIdExpense() {
		return idExpense;
	}

	public void setIdExpense(Integer idExpense) {
		this.idExpense = idExpense;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
