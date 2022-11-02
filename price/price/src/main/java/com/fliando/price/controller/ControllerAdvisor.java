package com.fliando.price.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@ControllerAdvice
public class ControllerAdvisor {

	@ExceptionHandler(InvalidNumberOfPeopleException.class)
	public ResponseEntity<Object> handleInvalidNumberOfPeople(InvalidNumberOfPeopleException ex, WebRequest re){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(TooManyReservationsException.class)
	public ResponseEntity<Object> handleTooManyPeopleReservation(TooManyReservationsException ex, WebRequest re){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NotEvenAnAdultException.class)
	public ResponseEntity<Object> handleNotEvenAnAdult(NotEvenAnAdultException ex, WebRequest re){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(IllegalLuggageException.class)
	public ResponseEntity<Object> handleIllegalLuggage(IllegalLuggageException ex, WebRequest re){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(JsonMappingException.class)
	public ResponseEntity<Object> handleJsonException1(JsonMappingException ex, WebRequest re){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(JsonProcessingException.class)
	public ResponseEntity<Object> handleJsonException2(JsonProcessingException ex, WebRequest re){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(FlightUnavailableException.class)
	public ResponseEntity<Object> handleFlightError(FlightUnavailableException ex, WebRequest re) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
