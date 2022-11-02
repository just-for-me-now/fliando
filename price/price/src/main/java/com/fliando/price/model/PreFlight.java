package com.fliando.price.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;

public class PreFlight {

	private long id;
	
	private String airline;
	
	private boolean scales;
	
	@JsonProperty("luggage-allowed")
	private boolean luggageAllowed;
	
	@JsonProperty("round-trip")
	private boolean roundTrip;

	private String time;
	
	private String origin;
	
	private String destination;

	public PreFlight(long id, String airline, boolean scales, boolean luggageAllowed, boolean roundTrip,
			String time, String origin, String destination) {
		this.id = id;
		this.airline = airline;
		this.scales = scales;
		this.luggageAllowed = luggageAllowed;
		this.roundTrip = roundTrip;
		this.time = time;
		this.origin = origin;
		this.destination = destination;
	}
	
	public PreFlight() {}

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", scales=" + scales + ", luggageAllowed=" + luggageAllowed
				+ ", roundTrip=" + roundTrip + ", time=" + time + ", origin=" + origin + ", destination=" + destination
				+ "]";
	}
	
	public Flight toFlight() {
		return new Flight(id, airline, scales,luggageAllowed, roundTrip, LocalDateTime.parse(time), origin, destination);
	}
	
}
