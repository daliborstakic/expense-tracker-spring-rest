package com.daliborstakic.rzk.proxies;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service", url = "http://localhost:8686/exchange")
public interface CurrencyExchangeProxy {
	@GetMapping("/getRate/from/{currency1}/to/{currency2}")
	public BigDecimal getRate(@PathVariable Integer currency1, @PathVariable Integer currency2);
}
