package com.fliando.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fliando.price.service.PriceService;
///price?flightId={id}&toddlers=0&children=0&adults=1&luggage=3
@RestController
public class Controller {

	private PriceService service;
	
	public Controller(PriceService service) {
		this.service = service;
	}
	
	//@ResponseBody
	@GetMapping("/price")
	public int method(@RequestParam long flightId, @RequestParam int toddlers,@RequestParam int children,@RequestParam int adults,@RequestParam int luggage) throws InvalidNumberOfPeopleException, TooManyReservationsException, NotEvenAnAdultException {
		return service.calculatePrice(flightId,toddlers,children, adults, luggage);
	}
	
}
