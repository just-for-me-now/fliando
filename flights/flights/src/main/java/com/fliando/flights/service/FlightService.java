package com.fliando.flights.service;

import java.time.LocalDateTime;
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
import com.fliando.flights.repo.IOriginsRepository;

@Service
public class FlightService {
	
	private static String logAddress = "http://localhost:8085/logs";
	
	private IOriginsRepository originRepo;
	private IDestinationsRepository destRepo;
	
	public FlightService(IOriginsRepository repo) {
		this.originRepo = repo;
	}

	public List<Origin> findAllOrigins() {
		
		InternalCommunications.post(logAddress, "Get request recieved: /origins ");

		return (List<Origin>) originRepo.findAll();
	}

	public List<Destination> findAllDestinations(long id) throws OriginUnknownException {
		
		Optional<Origin> origin = originRepo.findById(id);
		if(origin.isEmpty()) throw new OriginUnknownException();
		
		
		return origin.get().getDestinations();
	}

	public List<Flight> findAllDates(long originId, long destinationId, LocalDateTime date) throws OriginUnknownException, DestinationUnknownException {
		
		Optional<Origin> origin = originRepo.findById(originId);
		if(origin.isEmpty()) throw new OriginUnknownException();
		
		Optional<Destination> destination = destRepo.findById(destinationId);
		if(destination.isEmpty()) throw new DestinationUnknownException();
		
		if(destination.get().getOrigin().getId() != origin.get().getId()) {
			throw new OriginUnknownException();
		}
		
		return destination.get().getFlights();
	}

}
