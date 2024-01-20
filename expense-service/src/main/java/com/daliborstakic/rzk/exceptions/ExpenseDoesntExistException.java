package com.daliborstakic.rzk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExpenseDoesntExistException extends Exception {
	private static final long serialVersionUID = 1L;
	private Integer idExpense;

	public ExpenseDoesntExistException(String message, Integer idExpense) {
		super(message);
		this.idExpense = idExpense;
	}

	public Integer getIdExpense() {
		return idExpense;
	}

	public void setIdExpense(Integer idExpense) {
		this.idExpense = idExpense;
	}
}
