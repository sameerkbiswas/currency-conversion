package com.in28minutes.currency.conversion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.currency.conversion.bean.CurrencyConversion;

@FeignClient(name="currency-exchange", url="localhost:8000")
public interface CurrencyExchangeProxy {
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	CurrencyConversion retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to);
}
