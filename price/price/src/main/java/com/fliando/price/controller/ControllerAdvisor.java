package com.fliando.price.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fliando.price.lib.InternalCommunications;

@ControllerAdvice
public class ControllerAdvisor {

	@ExceptionHandler(InvalidNumberOfPeopleException.class)
	public ResponseEntity<Object> handleInvalidNumberOfPeople(InvalidNumberOfPeopleException ex, WebRequest re){
		InternalCommunications.log("Price - Price information request aborted: invalid number of people");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(TooManyReservationsException.class)
	public ResponseEntity<Object> handleTooManyPeopleReservation(TooManyReservationsException ex, WebRequest re){
		InternalCommunications.log("Price - Price information request aborted: invalid number of people");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NotEvenAnAdultException.class)
	public ResponseEntity<Object> handleNotEvenAnAdult(NotEvenAnAdultException ex, WebRequest re){
		InternalCommunications.log("Price - Price information request aborted: invalid number of people");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(IllegalLuggageException.class)
	public ResponseEntity<Object> handleIllegalLuggage(IllegalLuggageException ex, WebRequest re){
		InternalCommunications.log("Price - Price information request aborted: request of luggage in a flight that does not allow it");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(IllegalRoundTripException.class)
	public ResponseEntity<Object> handleIllegalRoundTrip(IllegalRoundTripException ex, WebRequest re){
		InternalCommunications.log("Price - Price information request aborted: request of a return flight in a flight that does not allow it");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(JsonMappingException.class)
	public ResponseEntity<Object> handleJsonException1(JsonMappingException ex, WebRequest re){
		InternalCommunications.log("Price - Price information request aborted: Json mapping exception");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(JsonProcessingException.class)
	public ResponseEntity<Object> handleJsonException2(JsonProcessingException ex, WebRequest re){
		InternalCommunications.log("Price - Price information request aborted: Json processing exception");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(FlightUnavailableException.class)
	public ResponseEntity<Object> handleFlightError(FlightUnavailableException ex, WebRequest re) {
		InternalCommunications.log("Price - Price information request aborted: flight information service unavailable for crosschecking");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
