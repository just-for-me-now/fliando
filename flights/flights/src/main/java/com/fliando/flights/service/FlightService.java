package com.fliando.flights.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fliando.flights.controller.OriginUnknownException;
import com.fliando.flights.lib.InternalCommunications;
import com.fliando.flights.model.Destination;
import com.fliando.flights.model.Origin;
import com.fliando.flights.repo.IOriginsRepository;

@Service
public class FlightService {
	
	private static String logAddress = "http://localhost:8085/logs";
	
	private IOriginsRepository repo;
	
	public FlightService(IOriginsRepository repo) {
		this.repo = repo;
	}

	public List<Origin> findAllOrigins() {
		
		InternalCommunications.post(logAddress, "Get request recieved: /origins ");

		return (List<Origin>) repo.findAll();
	}

	public List<Destination> findAllDestinations(long id) throws OriginUnknownException {
		
		Optional<Origin> origin = repo.findById(id);
		if(origin.isEmpty()) throw new OriginUnknownException();
		
		
		return origin.get().getDestinations();
	}

}
