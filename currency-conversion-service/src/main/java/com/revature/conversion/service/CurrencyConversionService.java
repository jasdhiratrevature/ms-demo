package com.revature.conversion.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.revature.conversion.model.CurrencyConversion;
import com.revature.conversion.model.CurrencyExchange;
@Service
public class CurrencyConversionService {

	@Autowired
	private WebClient webClient;
	
	  public CurrencyConversion calculateCurrencyConversion( String from, String
	  to, BigDecimal quantity) {
	  
	  CurrencyConversion currencyConversion=
	  webClient.get().uri("http://currency-exchange-service:8081", uriBuilder -> uriBuilder
	  .path("currency-exchange/from/{from}/to/{to}") .build(from,to)) .retrieve()
	  .bodyToMono(CurrencyConversion.class) .block();
	  
	  return currencyConversion;
	  
	  }
	 
}
