package com.daliborstakic.rzk.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.rzk.dtos.ExchangeRateDTO;
import com.daliborstakic.rzk.exceptions.ExchangeRateAlreadyExistsException;
import com.daliborstakic.rzk.exceptions.ExchangeRateDoesntExistException;
import com.daliborstakic.rzk.model.ExchangeRate;
import com.daliborstakic.rzk.services.ExchangeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/exchange")
public class CurrencyExchangeController {
	@Autowired
	private ExchangeService exchangeService;

	@GetMapping("/getRates")
	public List<ExchangeRate> getAllExchangeRates() {
		return exchangeService.getAllExchangeRates();
	}

	@PostMapping("/addRate")
	public ExchangeRate addExchangeRate(@RequestBody @Valid ExchangeRateDTO exchangeRate)
			throws ExchangeRateAlreadyExistsException {
		return exchangeService.addExchangeRate(exchangeRate);
	}

	@GetMapping("/getRate/from/{currency1}/to/{currency2}")
	public BigDecimal getRate(@PathVariable Integer currency1, @PathVariable Integer currency2)
			throws ExchangeRateAlreadyExistsException, ExchangeRateDoesntExistException {
		return exchangeService.getRate(currency1, currency2);
	}

	@PutMapping("/updateRate/{idExchangeRate}/amount/{amount}")
	public ExchangeRate updateRate(@PathVariable Integer idExchangeRate, @PathVariable BigDecimal amount)
			throws ExchangeRateDoesntExistException {
		return exchangeService.updateRate(idExchangeRate, amount);
	}
}
