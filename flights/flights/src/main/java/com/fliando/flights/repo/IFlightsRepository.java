package com.fliando.flights.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fliando.flights.model.Flight;

public interface IFlightsRepository extends CrudRepository<Flight, Long> {

	List<Flight> findByDestinationIdAndTimeBetween(long id, LocalDateTime first, LocalDateTime last);
}
