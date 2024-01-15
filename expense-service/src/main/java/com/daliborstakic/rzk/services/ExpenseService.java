package com.daliborstakic.rzk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.model.Expense;
import com.daliborstakic.rzk.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	ExpenseRepository expenseRepository;

	public List<Expense> getExpenses() {
		return expenseRepository.findAll();
	}
}
