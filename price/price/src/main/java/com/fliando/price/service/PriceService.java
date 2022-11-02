package com.fliando.price.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fliando.price.controller.FlightUnavailableException;
import com.fliando.price.controller.IllegalLuggageException;
import com.fliando.price.controller.InvalidNumberOfPeopleException;
import com.fliando.price.controller.NotEvenAnAdultException;
import com.fliando.price.controller.TooManyReservationsException;
import com.fliando.price.lib.InternalCommunication;
import com.fliando.price.model.Flight;

@Service
public class PriceService {

	private int baseAdult = 20;

	private int baseChild = 10;

	private int baseLuggage = 15;

	public int calculatePrice(long flightId, int toddlers, int children, int adults, int luggage)
			throws Exception {

		InternalCommunication.log("Price - Post request received");
		
		int totalPrice = getPriceFromPeople(toddlers, children, adults);
		
		Flight flight = InternalCommunication.getFlight("http://localhost:8084/flights/" + flightId);

		
		if (!flight.isLuggageAllowed() && luggage>0 || luggage<0) {
			throw new IllegalLuggageException();
		}
		
		if (flight.isLuggageAllowed()) {
			totalPrice += (baseLuggage * luggage);
		}

		totalPrice=(int)(checkAirLine(flight)*totalPrice);
		
		//This always last
		if (flight.isRoundTrip()) {
			totalPrice=(int)(1.7*totalPrice);
		}
		
		return totalPrice;
		
	}

	private int getPriceFromPeople(int toddlers, int children, int adults)
			throws InvalidNumberOfPeopleException, TooManyReservationsException, NotEvenAnAdultException {
		int totalPrice = 0;

		if (toddlers < 0 || children < 0 || adults < 0) {
			throw new InvalidNumberOfPeopleException();
		}
		if (toddlers + children + adults > 300) {
			throw new TooManyReservationsException();
		}
		if (adults < 0) {
			throw new NotEvenAnAdultException();
		}

		totalPrice += baseAdult * adults;

		totalPrice += baseChild * children;
		return totalPrice;
	}

	private double checkAirLine(Flight flight) {
	
		String airline = flight.getAirline();
		
		switch (airline) {
		case "Vueling":
			return 1.3;
		case "Tam":
			return 1.2;
		case "RyanAir":
			return 1.4;
		case "Lufthansa":
			return 1.6;
		case "Emirates":
			return 2;
		default:
			return 1;
			
		}
		
		
	
	}

}
