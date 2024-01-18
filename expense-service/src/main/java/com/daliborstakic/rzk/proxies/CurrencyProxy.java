package com.daliborstakic.rzk.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.daliborstakic.rzk.model.Currency;

@FeignClient(name = "currency-service", url = "http://localhost:8989/currencies")
public interface CurrencyProxy {
	@GetMapping("/getCurrency/{idCurrency}")
	public Currency getCurrency(@PathVariable Integer idCurrency);
}
