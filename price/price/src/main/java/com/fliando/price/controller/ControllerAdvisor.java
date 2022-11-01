package com.fliando.price.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

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
}
