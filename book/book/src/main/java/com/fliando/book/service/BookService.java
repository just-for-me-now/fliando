package com.fliando.book.service;

import org.springframework.stereotype.Service;

import com.fliando.book.controller.UnknownFlightException;
import com.fliando.book.lib.InternalCommunications;
import com.fliando.book.model.ReservationInfo;
import com.fliando.book.repo.IReservationInfoRepository;

@Service
public class BookService {
	
	private static String bookAddress = "http://localhost:8084/flights/";
	
	private IReservationInfoRepository repo;
	
	public BookService(IReservationInfoRepository repo) {
		this.repo = repo;
	}

	

	public void checkMakeReservation(ReservationInfo reservationInfo) throws UnknownFlightException {
		
		int returnedCode = InternalCommunications.check(bookAddress + reservationInfo.getFlightId());
		
		if(returnedCode != 200) {
			throw new UnknownFlightException();
		}
		
		repo.save(reservationInfo);
		
	}
	
	
}
