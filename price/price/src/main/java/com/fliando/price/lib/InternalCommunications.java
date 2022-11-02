package com.fliando.price.lib;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fliando.price.controller.FlightUnavailableException;
import com.fliando.price.model.Flight;
import com.fliando.price.model.PreFlight;

public class InternalCommunications {
	
	public static void log(String body) {
		String address = "http://localhost:8085/logs";
		try {
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).POST(BodyPublishers.ofString(body)).build();
			
			client.sendAsync(request, BodyHandlers.ofString()).join();
			
		} catch(Exception e) {
			// TODO: Maybe log the fact that the other microservice is not available?
			// We mainly are interested on decoupling from failure to respond
		}
	}

	public static Flight getFlight(long id) throws Exception {
		
		String address = "http://localhost:8084/flights/" + id;
		
		try {
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
		
		HttpResponse<String> htr = client.send(request, BodyHandlers.ofString());
		
		int code = htr.statusCode();
		if(code == 500 || code == 404) throw new Exception();
		
		String body = htr.body();
		ObjectMapper mapper = new ObjectMapper();
		PreFlight flight = new PreFlight();
		flight = mapper.readValue(body, PreFlight.class);

		return flight.toFlight();
		
		} catch (Exception e) {
			throw new FlightUnavailableException();
		}
	}
}
