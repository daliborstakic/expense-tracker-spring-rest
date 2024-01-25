package com.daliborstakic.rzk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.rzk.pojos.StatsResult;
import com.daliborstakic.rzk.services.ExpenseStatsService;

@RestController
@RequestMapping("/stats")
public class ExpenseStatsController {
	@Autowired
	public ExpenseStatsService expenseStatsService;

	@GetMapping("/month/{month}")
	public StatsResult getExpenseStatsByMonth(@RequestHeader("loggedUsername") String username,
			@PathVariable Integer month) {
		return expenseStatsService.getExpenseStatsByMonth(username, month);
	}
}
