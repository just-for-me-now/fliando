package com.fliando.price.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Flight {

	private long id;
	
	private long destination;

	private String airline;
	
	private String scales;
	
	@JsonProperty("luggage-allowed")
	private boolean luggageAllowed;
	
	private LocalDateTime date;
	
	public Flight(long destination, String airline, String scales, boolean luggageAllowed, LocalDateTime date) {
		this.destination = destination;
		this.airline = airline;
		this.scales = scales;
		this.luggageAllowed = luggageAllowed;
		this.date = date;
	}

	public Flight() {}

	public long getDestination() {
		return destination;
	}

	public void setDestination(long destination) {
		this.destination = destination;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getScales() {
		return scales;
	}

	public void setScales(String scales) {
		this.scales = scales;
	}

	public boolean isLuggageAllowed() {
		return luggageAllowed;
	}

	public void setLuggageAllowed(boolean luggageAllowed) {
		this.luggageAllowed = luggageAllowed;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", destination=" + destination + ", airline=" + airline + ", scales=" + scales
				+ ", luggageAllowed=" + luggageAllowed + ", date=" + date + "]";
	}
	
	

}
