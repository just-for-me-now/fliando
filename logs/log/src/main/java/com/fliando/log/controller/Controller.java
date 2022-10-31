package com.fliando.log.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fliando.log.service.LogService;

@RestController
public class Controller {
	
	@Autowired
	private LogService service;

	@PostMapping(path="/log")
	public ResponseEntity<Object> saveLog(@RequestBody String logText) {
		service.saveLog(logText);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@GetMapping(path ="/log")
	public List<String> retreiveAllData() {
		return service.findAllLogs();
	}
	
}
