package com.in28minutes.currency.conversion.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.currency.conversion.bean.CurrencyConversion;
import com.in28minutes.currency.conversion.service.CurrencyConversionService;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

	@Autowired private CurrencyConversionService currencyConversionService;
	
	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		return currencyConversionService.calculateCurrencyConversion(from, to, quantity);
	}
	
	@GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		return currencyConversionService.calculateCurrencyConversionFeign(from, to, quantity);
	}
}
