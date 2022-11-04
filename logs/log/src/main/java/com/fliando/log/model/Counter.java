package com.fliando.log.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Counter {
	@Id
	String name;
	int counter;
	public Counter(String name, int counter) {
		super();
		this.name = name;
		this.counter = counter;
	}
	public Counter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
}
