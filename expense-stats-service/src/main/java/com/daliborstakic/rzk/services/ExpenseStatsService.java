package com.daliborstakic.rzk.services;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.pojos.Category;
import com.daliborstakic.rzk.pojos.Expense;
import com.daliborstakic.rzk.pojos.StatsResult;
import com.daliborstakic.rzk.proxies.CategoryProxy;
import com.daliborstakic.rzk.proxies.ExpenseProxy;

@Service
public class ExpenseStatsService {
	@Autowired
	private ExpenseProxy expenseProxy;

	@Autowired
	private CategoryProxy categoryProxy;

	public StatsResult getExpenseStatsByMonth(String username, Integer month) {
		List<Expense> expenses = expenseProxy.getExpensesByMonth(username, month);

		Map<String, Double> sumByCurrency = expenses.stream().collect(Collectors
				.groupingBy(e -> e.getCurrency().getCurrencyCode(), Collectors.summingDouble(Expense::getAmount)));

		String monthRepresentation = Month.of(month).getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);

		StatsResult statsResult = new StatsResult(sumByCurrency, monthRepresentation);
		return statsResult;
	}

	public StatsResult getExpenseStatsByCategory(String username, Integer idCategory) {
		Category category = categoryProxy.getCategory(idCategory);

		List<Expense> expenses = expenseProxy.getExpensesByCategory(idCategory, username);

		Map<String, Double> sumByCurrency = expenses.stream().collect(Collectors
				.groupingBy(e -> e.getCurrency().getCurrencyCode(), Collectors.summingDouble(Expense::getAmount)));

		StatsResult statsResult = new StatsResult(sumByCurrency, category.getCategoryName());
		return statsResult;
	}
}
