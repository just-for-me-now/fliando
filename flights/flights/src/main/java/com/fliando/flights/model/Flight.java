package com.fliando.flights.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Destination destination;

	private String airline;
	
	private String scales;
	
	@Column(name="luggage-allowed")
	private boolean luggageAllowed;
	
	private LocalDateTime date;
	
	public Flight(Destination destination, String airline, String scales, boolean luggageAllowed, LocalDateTime date) {
		this.destination = destination;
		this.airline = airline;
		this.scales = scales;
		this.luggageAllowed = luggageAllowed;
		this.date = date;
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
