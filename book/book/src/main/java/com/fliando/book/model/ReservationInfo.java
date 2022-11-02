package com.fliando.book.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ReservationInfo {

	@Id
	@Column(name="flight-id")
	private long flightId;

	@OneToMany(fetch=FetchType.LAZY)
	private List<Passenger> passengers;
	
	private int luggage;
	
	private int price;

	public ReservationInfo(long flightId, List<Passenger> passengers, int luggage, int price) {
		this.flightId = flightId;
		this.passengers = passengers;
		this.luggage = luggage;
		this.price = price;
	}

	public ReservationInfo() {}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public int getLuggage() {
		return luggage;
	}

	public void setLuggage(int luggage) {
		this.luggage = luggage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
