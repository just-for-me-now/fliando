package com.fliando.flights.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fliando.flights.model.Origin;

@Service
public class FlightService {
	
	static List<Origin> origins;
	
	static {
		origins = new ArrayList<>();
		origins.add(new Origin(1,"Sevilla"));
		origins.add(new Origin(2,"Madrid"));
		origins.add(new Origin(3,"Barcelona"));
		origins.add(new Origin(4,"Valencia"));
		origins.add(new Origin(5,"Bilbao"));
	}

	public List<Origin> findAllOrigins() {
		
		return origins;
	}

}
