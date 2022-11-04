package com.fliando.users.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fliando.users.model.User;

public interface IUserRepository extends CrudRepository<User, String> {

	Optional<User> findByName(String name);
}
