package com.daliborstakic.rzk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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

	@NotBlank(message = "Amount cannot be blank")
	@Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "Amount must be a valid numeric value with up to two decimal places")
	private BigDecimal amount;

	@NotNull(message = "Date cannot be null")
	@Temporal(TemporalType.DATE)
	private Date date;

	@NotBlank(message = "Description cannot be blank")
	@Size(max = 255, message = "Description must be at most 255 characters")
	private String description;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "Category_idCategory")
	private Category category;

	// bi-directional many-to-one association to Currency
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "Currency_idCurrency")
	private Currency currency;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JsonIgnore
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

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
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