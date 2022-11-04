package com.fliando.users.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fliando.users.model.UserInfo;

public interface IUserRepository extends CrudRepository<UserInfo, String> {

	Optional<UserInfo> findByName(String name);
}
