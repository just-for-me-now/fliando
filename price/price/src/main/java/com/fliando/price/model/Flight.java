package com.fliando.price.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;

public class Flight {

	private long id;
	
	private String airline;
	
	private boolean scales;
	
	@JsonProperty("luggage-allowed")
	private boolean luggageAllowed;
	
	@JsonProperty("round-trip")
	private boolean roundTrip;

	private LocalDateTime date;
	
	private String origin;
	
	private long destination;

	public Flight(long id, String airline, boolean scales, boolean luggageAllowed, boolean roundTrip,
			LocalDateTime date, String origin, long destination) {
		this.id = id;
		this.airline = airline;
		this.scales = scales;
		this.luggageAllowed = luggageAllowed;
		this.roundTrip = roundTrip;
		this.date = date;
		this.origin = origin;
		this.destination = destination;
	}
	
	public Flight() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public boolean isScales() {
		return scales;
	}

	public void setScales(boolean scales) {
		this.scales = scales;
	}

	public boolean isLuggageAllowed() {
		return luggageAllowed;
	}

	public void setLuggageAllowed(boolean luggageAllowed) {
		this.luggageAllowed = luggageAllowed;
	}

	public boolean isRoundTrip() {
		return roundTrip;
	}

	public void setRoundTrip(boolean roundTrip) {
		this.roundTrip = roundTrip;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public long getDestination() {
		return destination;
	}

	public void setDestination(long destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", scales=" + scales + ", luggageAllowed=" + luggageAllowed
				+ ", roundTrip=" + roundTrip + ", date=" + date + ", origin=" + origin + ", destination=" + destination
				+ "]";
	}
	
}
