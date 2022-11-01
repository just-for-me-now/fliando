package com.fliando.log.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.fliando.log.model.Log;
import com.fliando.log.repo.ILogsRepository;

@Service
public class LogService {
	
	private static ILogsRepository repo;
	
	public LogService(ILogsRepository repo) {
		this.repo = repo;
	}
	
	public void saveLog(String message) {
		repo.save(new Log(message));
	}

	public List<Log> findAllLogs() {
		return (List<Log>) repo.findAll();
	}

}
