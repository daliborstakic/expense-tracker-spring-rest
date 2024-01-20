package com.daliborstakic.rzk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daliborstakic.rzk.model.Currency;
import com.daliborstakic.rzk.model.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
	Optional<ExchangeRate> findByCurrency1AndCurrency2(Currency currency1, Currency currency2);

	@Query("SELECT e FROM ExchangeRate e INNER JOIN e.currency1 c1 INNER JOIN e.currency2 c2 WHERE c1.idCurrency = ?1 AND c2.idCurrency = ?2")
	Optional<ExchangeRate> findByIdCurrency1AndIdCurrency2(Integer currency1, Integer currency2);

}
