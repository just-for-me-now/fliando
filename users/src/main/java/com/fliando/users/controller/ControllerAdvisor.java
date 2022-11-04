package com.fliando.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fliando.users.lib.InternalCommunications;
import com.fliando.users.model.UserInfo;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserInfo> handleUserNotFound(){
		InternalCommunications.log("User - user not found");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(WrongPasswordException.class)
	public ResponseEntity<UserInfo> handleWrongPassword(){
		InternalCommunications.log("User - password not valid");
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	
}
