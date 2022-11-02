package com.fliando.book.repo;

import org.springframework.data.repository.CrudRepository;

import com.fliando.book.model.Passenger;

public interface IPassengerRepository extends CrudRepository<Passenger, String> {

}