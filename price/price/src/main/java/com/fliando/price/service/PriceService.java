package com.fliando.price.service;

import org.springframework.stereotype.Service;

import com.fliando.price.controller.InvalidNumberOfPeopleException;
import com.fliando.price.controller.NotEvenAnAdultException;
import com.fliando.price.controller.TooManyReservationsException;
import com.fliando.price.lib.InternalCommunication;
import com.fliando.price.model.Flight;

@Service
public class PriceService {

	private int basePrice = 50;

	private int baseAdult = 20;

	private int baseChild = 10;

	private int baseLuggage = 15;

	public int calculatePrice(long flightId, int toddlers, int children, int adults, int luggage)
			throws InvalidNumberOfPeopleException, TooManyReservationsException, NotEvenAnAdultException {

		int totalPrice = 50;

		if (toddlers < 0 || children < 0 || adults < 0) {
			throw new InvalidNumberOfPeopleException();
		}
		if (toddlers + children + adults > 300) {
			throw new TooManyReservationsException();
		}
		if (adults < 0) {
			throw new NotEvenAnAdultException();
		}

		Flight flight = InternalCommunication.get("http://localhost:8084/flights", flightId);

		if (adults > 1) {
			totalPrice += (baseAdult * (adults - 1));
		}

		if (children > 0) {
			totalPrice += (baseChild * children);
		}

		if (flight.isLuggageAllowed()) {
			totalPrice += (baseLuggage * luggage);
		}
		// TODO: add boolean roundTrip
		
		totalPrice=(int)(totalPrice*checkAirLine(flight));
		
		//This always last
		if (flight.isRoundTrip()) {
			totalPrice=(int)(totalPrice*1.7);
		}
		
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
		default:
			//"Emirates"
			return 2;
			
		}
		
		
	
	}

}
