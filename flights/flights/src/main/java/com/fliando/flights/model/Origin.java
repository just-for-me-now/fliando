package com.fliando.flights.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Origin {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	public Origin(String name) {
		super();
		this.name = name;
	}
	
	public Origin() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Origin [id=" + id + ", name=" + name + "]";
	};
	
	
	
	
	
}
