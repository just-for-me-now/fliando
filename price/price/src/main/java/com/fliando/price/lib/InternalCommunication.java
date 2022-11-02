package com.fliando.price.lib;

import static io.restassured.RestAssured.given;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fliando.price.controller.FlightUnavailableException;
import com.fliando.price.model.Flight;
import com.fliando.price.model.PreFlight;

import io.restassured.http.ContentType;

public class InternalCommunication {
	
	private static String address = "http://localhost:8085/logs";
	
	public static void log(String body) {
		try {
			given().contentType(ContentType.JSON).body(body).
			post(address);
		} catch(Exception e) {
			// TODO: Maybe log the fact that the other microservice is not available?
			// We mainly are interested on decoupling from failure to respond
		}
	}

	public static Flight getFlight(String address) throws Exception {
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
		
		HttpResponse<String> htr = client.sendAsync(request, BodyHandlers.ofString()).join();
		
		String body = htr.body();
		
		ObjectMapper mapper = new ObjectMapper();
		
		PreFlight flight = new PreFlight();
		
		flight = mapper.readValue(body, PreFlight.class);
		
		return flight.toFlight();
		
	}
}
