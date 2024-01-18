package com.daliborstakic.rzk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.dtos.ExpenseDTO;
import com.daliborstakic.rzk.model.Category;
import com.daliborstakic.rzk.model.Currency;
import com.daliborstakic.rzk.model.Expense;
import com.daliborstakic.rzk.model.User;
import com.daliborstakic.rzk.proxies.CategoryProxy;
import com.daliborstakic.rzk.proxies.CurrencyProxy;
import com.daliborstakic.rzk.proxies.UserProxy;
import com.daliborstakic.rzk.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	ExpenseRepository expenseRepository;

	@Autowired
	private UserProxy userProxy;

	@Autowired
	private CurrencyProxy currencyProxy;

	@Autowired
	private CategoryProxy categoryProxy;

	public List<Expense> getExpenses(String username) {
		return expenseRepository.findByUsername(username);
	}

	public Expense addExpense(ExpenseDTO expense, String username) {
		User user = userProxy.findByUsername(username);
		Currency currency = currencyProxy.getCurrency(expense.getCurrency());
		Category category = categoryProxy.getCategory(expense.getCategory());

		Expense savedExpense = new Expense();

		savedExpense.setUser(user);
		savedExpense.setCurrency(currency);
		savedExpense.setCategory(category);
		savedExpense.setDate(expense.getDate());
		savedExpense.setAmount(expense.getAmount());
		savedExpense.setDescription(expense.getDescription());

		return expenseRepository.save(savedExpense);
	}
}
