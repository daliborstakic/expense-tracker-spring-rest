package com.daliborstakic.rzk.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.daliborstakic.rzk.pojos.Expense;

import feign.Headers;

@Headers("Accept: application/json")
@FeignClient(name = "expense-service", url = "http://localhost:8000/expenses")
public interface ExpenseProxy {
	@GetMapping("/getExpensesByMonth/{month}")
	List<Expense> getExpensesByMonth(@RequestHeader("loggedUsername") String username,
			@PathVariable("month") Integer month);
}
