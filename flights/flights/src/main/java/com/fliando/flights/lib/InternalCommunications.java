package com.fliando.flights.lib;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

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
}
