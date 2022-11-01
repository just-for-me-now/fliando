package com.fliando.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fliando.flights.model.Origin;
import com.fliando.flights.repo.IOriginsRepository;

@Component
public class Prepopulator implements CommandLineRunner {
	
	@Autowired
	private IOriginsRepository repo;

	@Override
	public void run(String... args) throws Exception {
		
		repo.save(new Origin("Sevilla"));
		repo.save(new Origin("Madrid"));
		repo.save(new Origin("Barcelona"));
		repo.save(new Origin("Valencia"));
		repo.save(new Origin("Bilbao"));
	}

}
