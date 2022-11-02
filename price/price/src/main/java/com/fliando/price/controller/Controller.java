package com.fliando.price.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fliando.price.service.PriceService;

@RestController
@CrossOrigin
public class Controller {

	private PriceService service;
	
	public Controller(PriceService service) {
		this.service = service;
	}
	
	//@ResponseBody
	@GetMapping("/price")
	public int method(@RequestParam long flightId, @RequestParam int toddlers,@RequestParam int children,@RequestParam int adults,@RequestParam int luggage, @RequestParam boolean roundTrip) throws Exception {
		return service.calculatePrice(flightId, toddlers, children, adults, luggage, roundTrip);
	}
	
}
