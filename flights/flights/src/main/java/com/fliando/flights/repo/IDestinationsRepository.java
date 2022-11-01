package com.fliando.flights.repo;

import org.springframework.data.repository.CrudRepository;

import com.fliando.flights.model.Destination;

public interface IDestinationsRepository extends CrudRepository<Destination, Long>{

}
