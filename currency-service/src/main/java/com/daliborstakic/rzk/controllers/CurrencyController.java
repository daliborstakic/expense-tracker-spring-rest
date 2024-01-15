package com.daliborstakic.rzk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.rzk.model.Currency;
import com.daliborstakic.rzk.services.CurrencyService;

@RestController
public class CurrencyController {
	@Autowired
	private CurrencyService currencyService;

	@GetMapping("/getCurrencies")
	public List<Currency> getCurrencies() {
		return currencyService.getCurrencies();
	}
	
	@PostMapping("/addCurrency")
	public Currency addCurrency(@RequestBody Currency currency) {
		return currencyService.addCurrency(currency);
	}
}