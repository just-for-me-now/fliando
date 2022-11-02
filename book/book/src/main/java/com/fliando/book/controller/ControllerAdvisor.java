package com.fliando.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fliando.book.lib.InternalCommunications;
import com.fliando.book.model.ReservationInfo;




	@ControllerAdvice
	public class ControllerAdvisor extends ResponseEntityExceptionHandler {

		@ExceptionHandler(UnknownFlightOrUnreachableFlightServiceException.class)
	    public ResponseEntity<ReservationInfo> handleUnknownFlight(UnknownFlightOrUnreachableFlightServiceException exc, WebRequest req) {
			InternalCommunications.log("Book - Booking aborted: either unknown flight or unreachable flight service");
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		
		@ExceptionHandler(WrongPriceOrUnreachablePriceServiceException.class)
	    public ResponseEntity<ReservationInfo> handleWrongPrice(WrongPriceOrUnreachablePriceServiceException exc, WebRequest req) {
			InternalCommunications.log("Book - Booking aborted: price inconsistency or unreachable pricing service");
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		
		@ExceptionHandler(IdentityTheftException.class)
	    public ResponseEntity<ReservationInfo> handleIdentityTheft(IdentityTheftException exc, WebRequest req) {
			InternalCommunications.log("Book - Booking aborted: passenger data inconsistencies found");
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		
		@ExceptionHandler(WrongPassengersException.class)
	    public ResponseEntity<ReservationInfo> handleWrongPassengers(WrongPassengersException exc, WebRequest req) {
			InternalCommunications.log("Book - Booking aborted: No passengers or no adults are not allowed");
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		
		@ExceptionHandler(NoFlyListException.class)
	    public ResponseEntity<ReservationInfo> handleNoFlyList(NoFlyListException exc, WebRequest req) {
			InternalCommunications.log("Book - Booking aborted: Abraham Rojas is on the no-fly list");
	        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	    }

	}

