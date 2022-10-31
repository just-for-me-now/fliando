package com.fliando.log.service;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class LogService {
	
	static List<String> logs = new ArrayList<>();

	public void saveLog(String logText) {
		logs.add(logText);
	}

	public List<String> findAllLogs() {
		// TODO Auto-generated method stub
		return logs;
	}

}
