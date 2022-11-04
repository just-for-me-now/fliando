package com.fliando.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fliando.users.model.User;
import com.fliando.users.repository.IUserRepository;

@Component
public class Prepopulator implements CommandLineRunner{

	
	private IUserRepository repo;
	
	public void run(String... args) throws Exception {
		User user = new User("admin","1234");
		
	}

	
}
