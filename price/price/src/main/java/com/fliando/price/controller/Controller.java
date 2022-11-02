package com.fliando.price.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fliando.price.service.PriceService;

@RestController
public class Controller {

	private PriceService service;
	
	public Controller(PriceService service) {
		this.service = service;
	}
	
	//@ResponseBody
	@GetMapping("/price")
	public int method(@RequestParam long flightId, @RequestParam int toddlers,@RequestParam int children,@RequestParam int adults,@RequestParam int luggage) throws InvalidNumberOfPeopleException, TooManyReservationsException, NotEvenAnAdultException, IllegalLuggageException {
		return service.calculatePrice(flightId,toddlers,children, adults, luggage);
	}
	
}
