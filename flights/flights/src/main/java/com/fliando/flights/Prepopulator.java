package com.fliando.flights;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fliando.flights.model.Destination;
import com.fliando.flights.model.Flight;
import com.fliando.flights.model.Origin;
import com.fliando.flights.repo.IDestinationsRepository;
import com.fliando.flights.repo.IFlightsRepository;
import com.fliando.flights.repo.IOriginsRepository;

@Component
public class Prepopulator implements CommandLineRunner {
	
	@Autowired
	private IOriginsRepository repo;
	@Autowired
	private IDestinationsRepository destinationsRepo;
	@Autowired
	private IFlightsRepository flightsRepo;
	

	@Override
	public void run(String... args) throws Exception {
		
		Origin origin1 = new Origin("Sevilla");
		Origin origin2 = new Origin("Madrid");
		Origin origin3 = new Origin("Barcelona");
		Origin origin4 = new Origin("Valencia");
		Origin origin5 = new Origin("Bilbao");

		
		Destination destination1 = new Destination("Lisboa");
		Destination destination2 = new Destination("Oporto");
		Destination destination3 = new Destination("Coimbra");
		Destination destination4 = new Destination("Madeira");
		
		destination1.setOrigin(origin1);
		destination2.setOrigin(origin1);
		destination3.setOrigin(origin1);
		destination4.setOrigin(origin1);
		
		Destination destination5 = new Destination("Berlin");
		Destination destination6 = new Destination("Hamburgo");
		Destination destination7 = new Destination("Leipzig");
		Destination destination8 = new Destination("Frankfurt");
		
		destination5.setOrigin(origin2);
		destination6.setOrigin(origin2);
		destination7.setOrigin(origin2);
		destination8.setOrigin(origin2);
		
		Destination destination9 = new Destination("Burdeos");
		Destination destination10 = new Destination("Paris");
		Destination destination11 = new Destination("Marsella");
		Destination destination12 = new Destination("Tolouse");
		
		destination9.setOrigin(origin3);
		destination10.setOrigin(origin3);
		destination11.setOrigin(origin3);
		destination12.setOrigin(origin3);
		
		Destination destination13 = new Destination("Roma");
		Destination destination14 = new Destination("Milan");
		Destination destination15 = new Destination("Palermo");
		Destination destination16 = new Destination("Venecia");
		
		destination13.setOrigin(origin4);
		destination14.setOrigin(origin4);
		destination15.setOrigin(origin4);
		destination16.setOrigin(origin4);
		
		Destination destination17 = new Destination("Washington");
		Destination destination18 = new Destination("Wichita");
		Destination destination19 = new Destination("Chicago");
		Destination destination20 = new Destination("Philadephia");
		
		destination17.setOrigin(origin5);
		destination18.setOrigin(origin5);
		destination19.setOrigin(origin5);
		destination20.setOrigin(origin5);

		repo.save(origin1);
		repo.save(origin2);
		repo.save(origin3);
		repo.save(origin4);
		repo.save(origin5);
			
		
		destinationsRepo.save(destination1);
		destinationsRepo.save(destination2);
		destinationsRepo.save(destination3);
		destinationsRepo.save(destination4);
		destinationsRepo.save(destination5);
		destinationsRepo.save(destination6);
		destinationsRepo.save(destination7);
		destinationsRepo.save(destination8);
		destinationsRepo.save(destination9);
		destinationsRepo.save(destination10);
		destinationsRepo.save(destination11);
		destinationsRepo.save(destination12);
		destinationsRepo.save(destination13);
		destinationsRepo.save(destination14);
		destinationsRepo.save(destination15);
		destinationsRepo.save(destination16);
		destinationsRepo.save(destination17);
		destinationsRepo.save(destination18);
		destinationsRepo.save(destination19);
		destinationsRepo.save(destination20);

		getFlights(destination1);
		getFlights(destination2);
		getFlights(destination3);
		getFlights(destination4);
		getFlights(destination5);
		getFlights(destination6);
		getFlights(destination7);
		getFlights(destination8);
		getFlights(destination9);
		getFlights(destination10);
		getFlights(destination11);
		getFlights(destination12);
		getFlights(destination13);
		getFlights(destination14);
		getFlights(destination15);
		getFlights(destination16);
		getFlights(destination17);
		getFlights(destination18);
		getFlights(destination19);
		getFlights(destination20);
		
		getTestFlight(destination1);
		
		
	}

	private String airline() {
		int r =(int)  Math.ceil(Math.random() * 5);
		switch(r) {
		case 1:
			return "Vueling";
		case 2:
			return "Tam";
		case 3:
			return "RyanAir";
		case 4:
			return "Lufthansa";
		default:
			return "Emirates";
		}
	}
	
	private String scales() {
		double r = Math.random();
		if(r < 0.5) {
			return "Yes";
		} else {
			return "No";
		}
	}
	
	private boolean halfAndHalf() {
		double r = Math.random();
		if(r < 0.5) {
			return true;
		} else {
			return false;
		}
	}
	
	public void getFlights(Destination d) {
		
		LocalDateTime now = LocalDateTime.now();
		
		for(int i = 1; i <= 30; i++) {
			
			LocalDateTime morning = now.plusDays(i).truncatedTo(ChronoUnit.DAYS).plusHours(8);
			LocalDateTime afternoon = morning.plusHours(12);
			
			Flight morningFlight = new Flight(airline(), halfAndHalf(), halfAndHalf(), halfAndHalf(), morning);
			Flight afternoonFlight = new Flight(airline(), halfAndHalf(), halfAndHalf(), halfAndHalf(), afternoon);
			
			morningFlight.setDestination(d);
			afternoonFlight.setDestination(d);

			flightsRepo.save(morningFlight);
			flightsRepo.save(afternoonFlight);
		}
		
	}
	
	private void getTestFlight(Destination destination1) {
		Flight flight = new Flight("testAirlines", false, false, false, LocalDateTime.now().minusYears(10));
		flight.setDestination(destination1);
		
		flightsRepo.save(flight);
	}

}
