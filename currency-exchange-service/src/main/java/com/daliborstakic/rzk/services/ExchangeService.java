package com.daliborstakic.rzk.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daliborstakic.rzk.dtos.ExchangeRateDTO;
import com.daliborstakic.rzk.exceptions.ExchangeRateAlreadyExistsException;
import com.daliborstakic.rzk.exceptions.ExchangeRateDoesntExistException;
import com.daliborstakic.rzk.model.Currency;
import com.daliborstakic.rzk.model.ExchangeRate;
import com.daliborstakic.rzk.proxies.CurrencyProxy;
import com.daliborstakic.rzk.repositories.ExchangeRateRepository;

@Service
public class ExchangeService {
	@Autowired
	private ExchangeRateRepository exchangeRateRepo;

	@Autowired
	private CurrencyProxy currencyProxy;

	public List<ExchangeRate> getAllExchangeRates() {
		return exchangeRateRepo.findAll();
	}

	public ExchangeRate addExchangeRate(ExchangeRateDTO exchangeRate) throws ExchangeRateAlreadyExistsException {
		Currency from = currencyProxy.getCurrency(exchangeRate.getCurrency1());
		Currency to = currencyProxy.getCurrency(exchangeRate.getCurrency2());

		ExchangeRate newExchangeRate = new ExchangeRate();
		newExchangeRate.setCurrency1(from);
		newExchangeRate.setCurrency2(to);
		newExchangeRate.setRate(exchangeRate.getRate());

		Optional<ExchangeRate> existingRate = exchangeRateRepo.findByCurrency1AndCurrency2(from, to);

		if (existingRate.isPresent())
			throw new ExchangeRateAlreadyExistsException("Exchange rate with the given currencies already exists!",
					exchangeRate);

		return exchangeRateRepo.save(newExchangeRate);
	}

	public BigDecimal getRate(Integer currency1, Integer currency2) throws ExchangeRateDoesntExistException {
		Currency from = currencyProxy.getCurrency(currency1);
		Currency to = currencyProxy.getCurrency(currency2);

		Optional<ExchangeRate> exchangeRate = exchangeRateRepo.findByCurrency1AndCurrency2(from, to);

		if (exchangeRate.isEmpty())
			throw new ExchangeRateDoesntExistException("Exchange rate with the given currencies doesn't exist!",
					List.of(currency1, currency2));

		return exchangeRate.get().getRate();
	}

	public ExchangeRate updateRate(Integer idExchangeRate, BigDecimal amount) throws ExchangeRateDoesntExistException {
		Optional<ExchangeRate> exists = exchangeRateRepo.findById(idExchangeRate);

		if (exists.isEmpty())
			throw new ExchangeRateDoesntExistException("Exchange rate with the given id doesn't exist!",
					idExchangeRate);

		exists.get().setRate(amount);
		return exchangeRateRepo.save(exists.get());
	}
}
