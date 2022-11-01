package com.fliando.flights.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Destination {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Origin origin;
	
	@OneToMany(mappedBy="destination", fetch=FetchType.LAZY)
	private List<Flight> flights;
	
	public Destination(String name) {
		this.name = name;
	}

	public Destination() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", name=" + name + "]";
	}
	
}
