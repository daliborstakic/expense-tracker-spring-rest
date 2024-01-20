package com.daliborstakic.rzk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.rzk.dtos.ExpenseDTO;
import com.daliborstakic.rzk.exceptions.ExpenseDoesntExistException;
import com.daliborstakic.rzk.model.Expense;
import com.daliborstakic.rzk.services.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/getExpenses")
	public List<Expense> getExpenses(@RequestHeader("loggedUsername") String username) {
		return expenseService.getExpenses(username);
	}

	@PostMapping("/addExpense")
	public Expense addExpense(@RequestBody @Valid ExpenseDTO expense,
			@RequestHeader("loggedUsername") String username) {
		return expenseService.addExpense(expense, username);
	}

	@DeleteMapping("/deleteExpense/{idExpense}")
	public String deleteExpense(@PathVariable Integer idExpense, @RequestHeader("loggedUsername") String username)
			throws ExpenseDoesntExistException {
		return expenseService.deleteExpense(idExpense, username);
	}

	@PutMapping("/changeCurrencyExpense/{idExpense}/to/{idCurrency}")
	public Expense changeCurrencyExpense(@PathVariable Integer idExpense,
			@RequestHeader("loggedUsername") String username, @PathVariable Integer idCurrency)
			throws ExpenseDoesntExistException {
		return expenseService.changeCurrencyExpense(idExpense, username, idCurrency);
	}
}
