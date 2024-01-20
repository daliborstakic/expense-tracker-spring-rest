package com.daliborstakic.rzk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.rzk.exceptions.CurrencyAlreadyExistsException;
import com.daliborstakic.rzk.exceptions.CurrencyNotFoundException;
import com.daliborstakic.rzk.model.Currency;
import com.daliborstakic.rzk.services.CurrencyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {
	@Autowired
	private CurrencyService currencyService;

	@GetMapping("/getCurrencies")
	public List<Currency> getCurrencies() {
		return currencyService.getCurrencies();
	}

	@PostMapping("/addCurrency")
	public Currency addCurrency(@RequestBody @Valid Currency currency) throws CurrencyAlreadyExistsException {
		return currencyService.addCurrency(currency);
	}

	@GetMapping("/getCurrency/{idCurrency}")
	public Currency getCurrency(@PathVariable Integer idCurrency) throws CurrencyNotFoundException {
		return currencyService.getCurrency(idCurrency);
	}
}
