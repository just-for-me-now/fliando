package com.fliando.flights.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fliando.flights.model.Destination;
import com.fliando.flights.model.Flight;
import com.fliando.flights.model.Origin;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OriginUnknownException.class)
    public ResponseEntity<Origin> handleOriginNotFound(OriginUnknownException exc, WebRequest req) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DestinationUnknownException.class)
    public ResponseEntity<Destination> handleDestinationNotFound(DestinationUnknownException exc, WebRequest req) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<Flight> handleFlightNotFound(FlightNotFoundException exc, WebRequest req) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}