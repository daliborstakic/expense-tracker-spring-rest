package com.daliborstakic.rzk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.exceptions.CurrencyNotFoundException;
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

	public Currency getCurrency(Integer idCurrency) throws CurrencyNotFoundException {
		Optional<Currency> foundCurrency = currencyRepository.findById(idCurrency);

		if (foundCurrency.isEmpty())
			throw new CurrencyNotFoundException(idCurrency);

		return foundCurrency.get();
	}
}
