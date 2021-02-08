package com.in28minutes.currency.conversion.service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.currency.conversion.bean.CurrencyConversion;
import com.in28minutes.currency.conversion.proxy.CurrencyExchangeProxy;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
	@Autowired private CurrencyExchangeProxy proxy;
	
	@Override
	public CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity) {
		HashMap<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
				.getForEntity(CURRENCY_EXCHANGE_END_POINT, CurrencyConversion.class, uriVariables);
		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmmount(quantity.multiply(
				currencyConversion.getConversionMultiple()));
		
		return currencyConversion;
	}

	@Override
	public CurrencyConversion calculateCurrencyConversionFeign(String from, String to, BigDecimal quantity) {
		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmmount(quantity.multiply(
				currencyConversion.getConversionMultiple()));
		
		return currencyConversion;
	}
}
