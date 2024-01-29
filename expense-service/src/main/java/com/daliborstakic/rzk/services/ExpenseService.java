package com.daliborstakic.rzk.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.dtos.ExpenseDTO;
import com.daliborstakic.rzk.exceptions.ExpenseDoesntExistException;
import com.daliborstakic.rzk.model.Category;
import com.daliborstakic.rzk.model.Currency;
import com.daliborstakic.rzk.model.Expense;
import com.daliborstakic.rzk.model.User;
import com.daliborstakic.rzk.proxies.CategoryProxy;
import com.daliborstakic.rzk.proxies.CurrencyExchangeProxy;
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

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

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

	public String deleteExpense(Integer idExpense, String username) throws ExpenseDoesntExistException {
		Optional<Expense> foundExpense = expenseRepository.findByUsernameAndIdExpense(idExpense, username);

		if (foundExpense.isEmpty())
			throw new ExpenseDoesntExistException("The expense with the given id doesn't exits!", idExpense);

		expenseRepository.delete(foundExpense.get());
		return "Expense has been deleted!";
	}

	public Expense changeCurrencyExpense(Integer idExpense, String username, Integer idCurrency)
			throws ExpenseDoesntExistException {
		Optional<Expense> foundExpense = expenseRepository.findByUsernameAndIdExpense(idExpense, username);

		if (foundExpense.isEmpty())
			throw new ExpenseDoesntExistException("The expense with the given id doesn't exits!", idExpense);

		Currency toCurrency = currencyProxy.getCurrency(idCurrency);
		BigDecimal exchangeRate = currencyExchangeProxy.getRate(foundExpense.get().getCurrency().getIdCurrency(),
				idCurrency);

		Expense newExpense = foundExpense.get();
		newExpense.setCurrency(toCurrency);
		newExpense.setAmount(exchangeRate.multiply(newExpense.getAmount()));

		return expenseRepository.save(newExpense);
	}

	public List<Expense> getExpensesByMonth(Integer month, String username) {
		if (month < 1 || month > 12)
			throw new RuntimeException("Please enter a valid month!");

		return expenseRepository.getExpenseByMonth(username, month);
	}

	public List<Expense> getExpensesByCategory(Integer idCategory, String username) {
		categoryProxy.getCategory(idCategory);

		return expenseRepository.getExpensesByCategory(idCategory, username);
	}
}
