package com.fliando.flights.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Destination destination;

	private String airline;
	
	private String scales;
	
	@Column(name="luggage-allowed")
	private boolean luggageAllowed;
	
	@Column(name="round-trip")
	private boolean roundTrip;
	
	private LocalDateTime time;
	
	public Flight(String airline, String scales, boolean luggageAllowed, boolean roundTrip, LocalDateTime time) {
		super();
		this.airline = airline;
		this.scales = scales;
		this.luggageAllowed = luggageAllowed;
		this.roundTrip = roundTrip;
		this.time = time;
	}

	public Flight() {}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
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

	public boolean isRoundTrip() {
		return roundTrip;
	}

	public void setRoundTrip(boolean roundTrip) {
		this.roundTrip = roundTrip;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", destination=" + destination + ", airline=" + airline + ", scales=" + scales
				+ ", luggageAllowed=" + luggageAllowed + ", roundTrip=" + roundTrip + ", time=" + time + "]";
	}
	
}
