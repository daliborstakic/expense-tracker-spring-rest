package com.daliborstakic.rzk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daliborstakic.rzk.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
	Optional<Currency> findByCurrencyCode(String currencyCode);
}
