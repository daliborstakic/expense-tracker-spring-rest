package com.daliborstakic.rzk.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.pojos.Expense;
import com.daliborstakic.rzk.pojos.StatsResult;
import com.daliborstakic.rzk.proxies.ExpenseProxy;

@Service
public class ExpenseStatsService {
	@Autowired
	private ExpenseProxy expenseProxy;

	public StatsResult getExpenseStatsByMonth(String username, Integer month) {
		List<Expense> expenses = expenseProxy.getExpensesByMonth(username, month);

		Map<String, Double> sumByCurrency = expenses.stream().collect(Collectors
				.groupingBy(e -> e.getCurrency().getCurrencyCode(), Collectors.summingDouble(Expense::getAmount)));

		StatsResult statsResult = new StatsResult(sumByCurrency, month);

		return statsResult;
	}
}
