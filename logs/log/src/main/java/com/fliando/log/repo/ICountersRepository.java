package com.fliando.log.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fliando.log.model.Counter;

public interface ICountersRepository extends CrudRepository<Counter,String>{

	Optional<Counter> findByName(String name);

}
