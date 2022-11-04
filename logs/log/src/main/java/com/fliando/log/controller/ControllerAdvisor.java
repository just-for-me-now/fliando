package com.fliando.log.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fliando.log.model.Counter;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CounterNotFoundException.class)
    public ResponseEntity<Counter> handleCounterNotFound(CounterNotFoundException exc, WebRequest req) {
		
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}