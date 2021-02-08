package com.in28minutes.currency.conversion.service;

import java.math.BigDecimal;

import com.in28minutes.currency.conversion.bean.CurrencyConversion;

public interface CurrencyConversionService {
	String CURRENCY_EXCHANGE_END_POINT = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
	CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity);
	
	CurrencyConversion calculateCurrencyConversionFeign(String from, String to, BigDecimal quantity);
}
