package com.fliando.flights.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fliando.flights.controller.DestinationUnknownException;
import com.fliando.flights.controller.FlightNotFoundException;
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
	
	private IOriginsRepository originsRepo;
	private IDestinationsRepository destinationsRepo;
	private IFlightsRepository flightsRepo;
	
	public FlightService(IOriginsRepository originRepo, IFlightsRepository flightsRepo, IDestinationsRepository destinationsRepo) {
		this.originsRepo = originRepo;
		this.flightsRepo = flightsRepo;
		this.destinationsRepo = destinationsRepo;
	}

	public List<Origin> findAllOrigins() {
		
		InternalCommunications.log("Flight - Get request recieved: /origins ");

		return (List<Origin>) originsRepo.findAll();
	}

	public List<Destination> findAllDestinations(long id) throws OriginUnknownException {
		
		InternalCommunications.log(String.format("Flight - Get request recieved: /origins/%d/destinations", id));
		
		Origin origin = getOrigin(id);
		
		return origin.getDestinations();
	}

	public List<Flight> findDates(long originId, long destinationId, LocalDateTime date) throws OriginUnknownException, DestinationUnknownException {
		
		InternalCommunications.log(String.format("Flight - Get request recieved: /origins/%d/destinations/%d/dates/%s",
														originId, 
														destinationId, 
														date.toLocalDate().toString()));
		
		Origin origin = getOrigin(originId);
		
		Destination destination = getDestination(destinationId);
		
		checkRelationship(origin, destination);
		
		LocalDateTime first = getFirst(date);
		LocalDateTime last = first.plusDays(7);
		
		return flightsRepo.findByDestinationIdAndTimeBetween(destination.getId(), first, last);
		
	}

	public Flight findFlight(long id) throws FlightNotFoundException {
		
		InternalCommunications.log(String.format("Flight - Get request recieved: /flights/%d", id));
		
		Optional<Flight> flight = flightsRepo.findById(id);
		
		if(flight.isEmpty()) throw new FlightNotFoundException();
		
		return flight.get();
		
	}
	
	// Aux methods start here

	private Origin getOrigin(long originId) throws OriginUnknownException {
		
		Optional<Origin> oOrigin = originsRepo.findById(originId);
		
		if(oOrigin.isEmpty()) throw new OriginUnknownException();
		
		return oOrigin.get();
		
	}

	private Destination getDestination(long destinationId) throws DestinationUnknownException {
		
		Optional<Destination> oDestination = destinationsRepo.findById(destinationId);
		
		if(oDestination.isEmpty()) throw new DestinationUnknownException();
		
		return oDestination.get();
		
	}

	private void checkRelationship(Origin origin, Destination destination) throws DestinationUnknownException {
		
		if(destination.getOrigin().getId() != origin.getId()) 
			throw new DestinationUnknownException();
		
	}

	// Three days before 'date', with an absolute minimum of tomorrow
	private LocalDateTime getFirst(LocalDateTime date) {
		
		LocalDateTime first = date.minusDays(3);
		
		if(first.compareTo(LocalDateTime.now().plusDays(1).truncatedTo(ChronoUnit.DAYS)) < 0) {
			first = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).plusDays(1);
		}
		
		return first;
		
	}

}
