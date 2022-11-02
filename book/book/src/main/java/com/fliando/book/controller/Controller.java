package com.fliando.book.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fliando.book.model.Passenger;
import com.fliando.book.model.ReservationInfo;
import com.fliando.book.service.BookService;

@RestController
public class Controller {
	
	private BookService service;
	
	public Controller(BookService service) {
		this.service = service;
	}
	
	@PostMapping(path="/book")
	public ResponseEntity<Object> bookFlight(@RequestBody ReservationInfo reservationInfo) throws UnknownFlightException, WrongPriceException, IdentityTheftException {
		service.checkMakeReservation(reservationInfo);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping(path="/passengers")
	public List<Passenger> retrievePassengers() {
		return service.findAllPassengers();
	}
	
	
		
	
}
