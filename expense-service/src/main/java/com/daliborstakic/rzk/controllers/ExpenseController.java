package com.daliborstakic.rzk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.rzk.model.Expense;
import com.daliborstakic.rzk.services.ExpenseService;

@RestController
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/getExpenses")
	public List<Expense> getExpenses() {
		return expenseService.getExpenses();
	}
}
