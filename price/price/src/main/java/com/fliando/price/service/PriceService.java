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
	
	
	public int calculatePrice(long flightId, int toddlers, int children, int adults, int luggage) throws InvalidNumberOfPeopleException, TooManyReservationsException, NotEvenAnAdultException {
		
	if (toddlers<0 || children <0 || adults <0) {
		throw new InvalidNumberOfPeopleException();
	}
	if (toddlers+children+adults>300) {
		throw new TooManyReservationsException();
	}
	if (adults<0) {
		throw new NotEvenAnAdultException();
	}
		
	Flight flight = InternalCommunication.get("http://localhost:8084/flights", flightId);
	
	
	int totalPrice = 0;
		
		return 0;
	}

}
