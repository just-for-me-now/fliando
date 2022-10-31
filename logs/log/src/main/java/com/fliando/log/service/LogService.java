package com.fliando.log.service;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class LogService {
	
	static List<String> logs;
	
	static {
	
		logs = new ArrayList<>();
		logs.add("Hello world");
	}
	
	public void saveLog(String logText) {
		logs.add(logText);
	}

	public List<String> findAllLogs() {
		return logs;
	}

}
