package com.daliborstakic.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

/**
 * The persistent class for the Expense database table.
 * 
 */
@Entity
@NamedQuery(name = "Expense.findAll", query = "SELECT e FROM Expense e")
public class Expense implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExpense;

	private String amount;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String description;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "Category_idCategory")
	private Category category;

	// bi-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumn(name = "Currency_idCurrency")
	private Currency currency;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "User_idUser")
	private User user;

	public Expense() {
	}

	public int getIdExpense() {
		return this.idExpense;
	}

	public void setIdExpense(int idExpense) {
		this.idExpense = idExpense;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}