package com.revature.conversion.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.kafka.core.KafkaTemplate;

import com.revature.conversion.event.CurrencyEvent;
import com.revature.conversion.model.CurrencyConversion;
import com.revature.conversion.model.CurrencyExchange;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Service
public class CurrencyConversionService {

	@Autowired
	private WebClient webClient;
	@Autowired
	DiscoveryClient discoveryClient;
	@Autowired
	private KafkaTemplate<String, CurrencyEvent> kafkaTemplate;
	
	  public CurrencyConversion calculateCurrencyConversion( String from, String
	  to, BigDecimal quantity) {
	  
			
	  CurrencyConversion currencyConversion=
	  webClient.get().uri("http://currency-exchange-service", uriBuilder -> uriBuilder
	  .path("currency-exchange/from/{from}/to/{to}") .build(from,to)) .retrieve()
	  .bodyToMono(CurrencyConversion.class) .block();
	  
	  // use kafka here as a producer
	/*  kafkaTemplate.send("notificationTopic",new CurrencyEvent(this,
			  currencyConversion.getId(), currencyConversion.getFrom(), 
			  currencyConversion.getTo()));
		*/
		System.out.println("notofocation sent");
	  return currencyConversion;
	  
		 
	  }
	 
	
}
