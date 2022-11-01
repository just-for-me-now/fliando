package com.fliando.log.repo;

import org.springframework.data.repository.CrudRepository;

import com.fliando.log.model.Log;

public interface ILogsRepository extends CrudRepository<Log, Long>{

}
