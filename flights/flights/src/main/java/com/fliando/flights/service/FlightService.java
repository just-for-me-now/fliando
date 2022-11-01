package com.fliando.flights.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fliando.flights.model.Origin;
import com.fliando.flights.repo.IOriginsRepository;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

@Service
public class FlightService {
	
	private IOriginsRepository repo;
	
	public FlightService(IOriginsRepository repo) {
		this.repo = repo;
	}

	public List<Origin> findAllOrigins() {
		given().contentType(ContentType.JSON).body("test").
		post("http://localhost:8084/logs");
		return (List<Origin>) repo.findAll();
	}

}
