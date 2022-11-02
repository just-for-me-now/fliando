package com.fliando.flights.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightAsReturned extends Flight {
	
	@JsonProperty("origin")
	private String originName;
	@JsonProperty("destination")
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
