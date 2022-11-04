package com.fliando.log.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fliando.log.model.Counter;
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
	
	@GetMapping(path="/counts")
	public List<Counter> getAllCounters(){
		return service.findAllCounters();
		
	}
	
	@PatchMapping(path="/counts/{name}")
	public ResponseEntity<Object> incrementCounter(@PathVariable String name) throws CounterNotFoundException {
		service.increment(name);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	

	
	@PutMapping(path="/counts/origins/{name}")
	public ResponseEntity<Object> incrementOrCreateOrigin(@PathVariable String name) {
		service.incrementOrCreate("origins_" + name);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping(path="/counts/destinations/{name}")
	public ResponseEntity<Object> incrementOrCreateDestination(@PathVariable String name) {
		service.incrementOrCreate("destinations_" + name);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping(path="/counts/passengers/toddlers/{toddler}/children/{child}/adults/{adult}")
	public ResponseEntity<Object> incrementPassenger(@PathVariable int toddler, @PathVariable int child, @PathVariable int adult) {
		service.incrementPassengers(toddler,child,adult);
		
		return ResponseEntity.status(HttpStatus.OK).build();
		}
	
	
	
	
}
