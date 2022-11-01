package com.fliando.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fliando.log.model.Log;
import com.fliando.log.repo.ILogsRepository;

@Component
public class Prepopulator implements CommandLineRunner {
	
	@Autowired
	private ILogsRepository repo;

	@Override
	public void run(String... args) throws Exception {
		
		repo.save(new Log("Hello World"));
	}

}
