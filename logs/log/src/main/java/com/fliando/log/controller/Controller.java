package com.fliando.log.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fliando.log.model.Log;
import com.fliando.log.service.LogService;

@RestController
@CrossOrigin
public class Controller {
	
	private LogService service;
	
	public Controller(LogService service) {
		this.service = service;
	}

	@PostMapping(path="/logs")
	public ResponseEntity<Object> saveLog(@RequestBody String logText) {
		service.saveLog(logText);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@GetMapping(path ="/logs")
	public List<Log> retreiveAllData() {
		return service.findAllLogs();
	}
	
	@PatchMapping(path="/counts/{id}")
	public ResponseEntity<Object> incrementCounter(@PathVariable String name) throws CounterNotFoundException {
		service.increment(name);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
