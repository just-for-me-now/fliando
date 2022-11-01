package com.fliando.flights.repo;

import org.springframework.data.repository.CrudRepository;

import com.fliando.flights.model.Flight;

public interface IFlightsRepository extends CrudRepository<Flight, Long> {
}
