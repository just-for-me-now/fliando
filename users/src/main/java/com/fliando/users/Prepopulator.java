package com.fliando.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fliando.users.model.UserInfo;
import com.fliando.users.repository.IUserRepository;

@Component
public class Prepopulator implements CommandLineRunner{

	@Autowired
	private IUserRepository repo;
	
	public void run(String... args) throws Exception {
		UserInfo info = new UserInfo("admin","1234");
		repo.save(info);
	}

	
}
