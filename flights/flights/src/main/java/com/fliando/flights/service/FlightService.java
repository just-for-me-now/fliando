package com.fliando.flights.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fliando.flights.controller.DestinationUnknownException;
import com.fliando.flights.controller.OriginUnknownException;
import com.fliando.flights.lib.InternalCommunications;
import com.fliando.flights.model.Destination;
import com.fliando.flights.model.Flight;
import com.fliando.flights.model.Origin;
import com.fliando.flights.repo.IDestinationsRepository;
import com.fliando.flights.repo.IFlightsRepository;
import com.fliando.flights.repo.IOriginsRepository;

@Service
public class FlightService {
	
	private IOriginsRepository originRepo;
	private IDestinationsRepository destRepo;
	private IFlightsRepository flightsRepo;
	
	public FlightService(IOriginsRepository repo) {
		this.originRepo = repo;
	}

	public List<Origin> findAllOrigins() {
		
		InternalCommunications.post("http://localhost:8085/logs", "Flight - Get request recieved: /origins ");

		return (List<Origin>) originRepo.findAll();
	}

	public List<Destination> findAllDestinations(long id) throws OriginUnknownException {
		
		Optional<Origin> origin = originRepo.findById(id);
		if(origin.isEmpty()) throw new OriginUnknownException();
		
		
		return origin.get().getDestinations();
	}

	public List<Flight> findDates(long originId, long destinationId, LocalDateTime date) throws OriginUnknownException, DestinationUnknownException {
		
		return (List<Flight>) flightsRepo.findAll();
		/*
		Optional<Origin> origin = originRepo.findById(originId);
		if(origin.isEmpty()) throw new OriginUnknownException();
		
		Destination destination = null;
		for(Destination d : origin.get().getDestinations()) {
			if(d.getId() == destinationId) {
				destination = d;
				break;
			}
		}
		if(destination == null) throw new DestinationUnknownException();
		
		if(date == null) {
			date = LocalDateTime.now();
		}
		LocalDateTime first = date.minusDays(3).withHour(0).withMinute(0).withSecond(0).withNano(0);
		if(first.compareTo(LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0)) <= 0) {
			first = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0).plusDays(1);
		}
		LocalDateTime last = first.plusDays(7);
		
		return List.of(new Flight());//flightsRepo.findByDestinationIdAndDateBetween(destination.get().getId(), first, last); */
	}

}
