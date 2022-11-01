package com.fliando.flights.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fliando.flights.model.Destination;
import com.fliando.flights.model.Flight;
import com.fliando.flights.model.Origin;
import com.fliando.flights.service.FlightService;

import java.time.LocalDateTime;
import java.util.*;

@RestController
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
	
	@GetMapping(path="/origins/{originId}/destinations{destId}/dates")
	public List<Flight> retreiveDates(@PathVariable long originId, @PathVariable long destinationId) throws OriginUnknownException, DestinationUnknownException {
		return service.findAllDates(originId, destinationId);
	}
	
}
