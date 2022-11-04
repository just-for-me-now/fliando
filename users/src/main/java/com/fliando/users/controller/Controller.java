package com.fliando.users.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fliando.users.model.User;
import com.fliando.users.service.UserService;

@RestController
public class Controller {
	
	private UserService service;
	
	public Controller(UserService service) {
		this.service = service;
	}
	

	//post username and password; verify correct info; give 401 or 200
	@PostMapping(path="/users")
	public void checkUsernameAndPassword(@RequestBody User user) {
		service.verifyUsernameAndPassword();
	}
}
