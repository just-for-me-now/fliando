package com.fliando.flights.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fliando.flights.model.Origin;
import com.fliando.flights.service.FlightService;

import java.util.*;

@RestController
public class Controller {
	
	private FlightService service;
	
	public Controller (FlightService service) {
		this.service=service;
	}
	
	@GetMapping(path="/origins")
	public List<Origin> retreiveAllData(){
		return service.findAllOrigins();
	}
	
}
