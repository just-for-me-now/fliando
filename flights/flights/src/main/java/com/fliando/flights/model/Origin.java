package com.fliando.flights.model;

public class Origin {
	private int id;
	private String name;
	
	public Origin(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Origin() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Origin [id=" + id + ", name=" + name + "]";
	};
	
	
	
	
	
}
