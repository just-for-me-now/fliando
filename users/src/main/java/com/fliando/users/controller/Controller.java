package com.fliando.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fliando.users.model.UserInfo;
import com.fliando.users.service.UserService;

@RestController
public class Controller {
	
	private UserService service;
	
	public Controller(UserService service) {
		this.service = service;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> checkUsernameAndPassword(@RequestBody UserInfo user) throws Exception {
		service.verifyUsernameAndPassword(user);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
