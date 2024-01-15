package com.daliborstakic.rzk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.model.Currency;
import com.daliborstakic.rzk.repositories.CurrencyRepository;

@Service
public class CurrencyService {
	@Autowired
	CurrencyRepository currencyRepository;

	public List<Currency> getCurrencies() {
		return currencyRepository.findAll();
	}

	public Currency addCurrency(Currency currency) {
		return currencyRepository.save(currency);
	}
}
