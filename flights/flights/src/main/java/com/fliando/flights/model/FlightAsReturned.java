package com.fliando.flights.model;

public class FlightAsReturned extends Flight {
	private String originName;
	private String destinationName;
	
	public FlightAsReturned(long id) {
		super(id);
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
}
