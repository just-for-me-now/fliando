package com.fliando.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fliando.book.model.ReservationInfo;




	@ControllerAdvice
	public class ControllerAdvisor extends ResponseEntityExceptionHandler {

		@ExceptionHandler(UnknownFlightException.class)
	    public ResponseEntity<ReservationInfo> handleUnknownFlight(UnknownFlightException exc, WebRequest req) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		
		@ExceptionHandler(WrongPriceException.class)
	    public ResponseEntity<ReservationInfo> handleWrongPrice(WrongPriceException exc, WebRequest req) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		
		@ExceptionHandler(IdentityTheftException.class)
	    public ResponseEntity<ReservationInfo> handleIdentityTheft(IdentityTheftException exc, WebRequest req) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	}

