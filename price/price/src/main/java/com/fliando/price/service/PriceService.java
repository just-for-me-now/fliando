package com.fliando.price.service;

import org.springframework.stereotype.Service;

import com.fliando.price.controller.InvalidNumberOfPeopleException;
import com.fliando.price.controller.TooManyReservationsException;

@Service
public class PriceService {

	private int basePrice = 50;
	
	private int baseAdult = 20;
	
	private int baseChild = 10;
	
	private int baseLuggage = 15;
	
	
	
	public int calculatePrice(long flightId, int toddlers, int children, int adults, int luggage) throws InvalidNumberOfPeopleException, TooManyReservationsException {
		
	//check numbers
	if (toddlers<0 || children <0 || adults <0) {
		throw new InvalidNumberOfPeopleException();
	}
	if (toddlers+children+adults>300) {
		throw new TooManyReservationsException();
	}
	
		
		int totalPrice = 0;
	if (children>=1) {
		
	}
		
		return 0;
	}

}
