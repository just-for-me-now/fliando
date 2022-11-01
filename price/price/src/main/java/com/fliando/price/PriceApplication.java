package com.fliando.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceApplication.class, args);
		
		//GET /price?flightId={id}&toddlers=0&children=0&adults=1&luggage=3
	}

}
