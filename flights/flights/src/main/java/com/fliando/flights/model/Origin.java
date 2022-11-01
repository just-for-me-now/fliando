package com.fliando.flights.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Origin {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy="origin", fetch=FetchType.LAZY)
	private List<Destination> destinations;
	
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

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	@Override
	public String toString() {
		return "Origin [id=" + id + ", name=" + name + "]";
	}
	
}
