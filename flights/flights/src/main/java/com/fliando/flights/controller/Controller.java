package com.fliando.flights.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fliando.flights.model.Destination;
import com.fliando.flights.model.Flight;
import com.fliando.flights.model.Origin;
import com.fliando.flights.service.FlightService;

@RestController
@CrossOrigin
public class Controller {
	
	private FlightService service;
	
	public Controller (FlightService service) {
		this.service=service;
	}
	
	@GetMapping(path="/origins")
	public List<Origin> retrieveOrigins(){
		return service.findAllOrigins();
	}
	
	@GetMapping(path="/origins/{id}/destinations")
	public List<Destination> retreiveDestinations(@PathVariable long id) throws OriginUnknownException {
		return service.findAllDestinations(id);
	}
	
	@GetMapping(path="/origins/{originId}/destinations/{destinationId}/dates/{date}")
	public Flight[] retreiveDates(
			@PathVariable long originId, 
			@PathVariable long destinationId, 
			@PathVariable LocalDate date) 
					throws OriginUnknownException, DestinationUnknownException {
		return service.findDates(originId, destinationId, date.atStartOfDay()).toArray(new Flight[0]);
	}
	
	@GetMapping(path="/flights/{id}")
	public Flight retrieveFlight(@PathVariable long id) throws FlightNotFoundException {
		return service.findFlight(id);
	}
	
}
