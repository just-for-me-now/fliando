package com.fliando.users.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fliando.users.controller.UserNotFoundException;
import com.fliando.users.controller.WrongPasswordException;
import com.fliando.users.model.UserInfo;
import com.fliando.users.repository.IUserRepository;

@Service
public class UserService {
	
	private IUserRepository repo;
	
	public UserService(IUserRepository repo) {
		this.repo = repo;
	}

	public void verifyUsernameAndPassword(UserInfo user) throws Exception {
		Optional<UserInfo> oUser=repo.findByName(user.getName());
		
		if(oUser.isEmpty()) {
			throw new UserNotFoundException();
		}
		UserInfo userFound = oUser.get();
		if (!userFound.getPassword().equals(user.getPassword())) {
			throw new WrongPasswordException();
		}
		
	}

	
}
