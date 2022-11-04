package com.fliando.book.lib;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import com.fliando.book.controller.UnknownFlightOrUnreachableFlightServiceException;
import com.fliando.book.controller.WrongPriceOrUnreachablePriceServiceException;

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
	
	public static boolean checkFlightExists(long id) throws UnknownFlightOrUnreachableFlightServiceException {
		
		String address = "http://localhost:8084/flights/" + id;
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
		
		int code;
		try {
			code = client.send(request, BodyHandlers.ofString()).statusCode();
		} catch (Exception e) {
			throw new UnknownFlightOrUnreachableFlightServiceException();
		}
		
		return code == 200;
		
	}

	public static int checkPrice(long flightId, int toddlers, int children, int adults, int luggage, boolean roundTrip) throws WrongPriceOrUnreachablePriceServiceException {
		try {
			String address = "http://localhost:8082/price?flightId=" + flightId + "&toddlers=" + toddlers + "&children=" + children + "&adults=" + adults + "&luggage=" + luggage + "&roundTrip=" + roundTrip;
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
			
			return Integer.parseInt(client.send(request, BodyHandlers.ofString()).body());
			
		} catch(Exception e) {
			throw new WrongPriceOrUnreachablePriceServiceException();
		}
	}

	public static void logAddBooking() {
		String address = "http://localhost:8085/counts/bookings";
		
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
		
		try {
			client.send(request, BodyHandlers.ofString()).body();
		} catch (Exception e) {
		
			/*Log service is not connecting*/
		}
		
	}

	public static void logAddPassengers() {
		String address = "http://localhost:8086/counts/passengers";
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
		
		try {
			client.send(request, BodyHandlers.ofString()).body();
		} catch (Exception e) {
		
			/*Log service is not connecting*/
		}
		
		
	}
}
