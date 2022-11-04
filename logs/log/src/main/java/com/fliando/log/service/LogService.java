package com.fliando.log.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.fliando.log.controller.CounterNotFoundException;
import com.fliando.log.model.Counter;
import com.fliando.log.model.Log;
import com.fliando.log.repo.ICountersRepository;
import com.fliando.log.repo.ILogsRepository;

@Service
public class LogService {
	
	private static ILogsRepository repo;
	private static ICountersRepository counters;
	
	public LogService(ILogsRepository repo) {
		this.repo = repo;
	}
	
	public void saveLog(String message) {
		
		repo.save(new Log(message));
	}

	public List<Log> findAllLogs() {
		
		repo.save(new Log("Log - Logs were requested"));
		
		return (List<Log>) repo.findAll();
	}

	public void increment(String name) throws CounterNotFoundException {
		Optional<Counter> counter = counters.findByName(name);
		if(counter.isEmpty()) throw new CounterNotFoundException();
		
		counter.get().setCounter(counter.get().getCounter() + 1);
		
		counters.save(counter.get());
	}
	
	public void incrementOrCreate(String name) {
		Optional<Counter> oCounter = counters.findByName(name);
		Counter counter = null;
		if(oCounter.isEmpty()) {
			counter = counters.save(new Counter(name, 0));
		} else {
			counter = oCounter.get();
		}
		
		counter.setCounter(counter.getCounter() + 1);
		
		counters.save(counter);
	}
	
	
	public void incrementPassengers(int toddlers, int children, int adults) {
		
		int todCount = counters.findById("toddlers").get().getCounter();
		todCount += toddlers;
		
		counters.save(new Counter("toddlers", todCount));
		
		int childCount = counters.findById("children").get().getCounter();
		childCount += children;
		
		counters.save(new Counter("children", childCount));
		
		int adultCount = counters.findById("adults").get().getCounter();
		adultCount += adults;
		
		counters.save(new Counter("adults", adultCount));
		
	}

}
