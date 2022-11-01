package com.fliando.flights.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fliando.flights.lib.InternalCommunications;
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

}
