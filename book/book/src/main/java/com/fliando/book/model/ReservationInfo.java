package com.fliando.book.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ReservationInfo {

	@Id
	@GeneratedValue
	private long id;
	@Column(name="flight-id")
	private long flightId;
	
	private int toddlers;
	
	private int children;
	
	private int adults;
	
	private int luggage;
	
	private int price;
	
	public ReservationInfo() {
	}
	
	

	public ReservationInfo(long flightId, int toddlers, int children, int adults, int luggage,int price) {
		super();
		this.flightId = flightId;
		this.toddlers = toddlers;
		this.children = children;
		this.adults = adults;
		this.luggage = luggage;
		this.price = price;
	}



	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public int getToddlers() {
		return toddlers;
	}

	public void setToddlers(int toddlers) {
		this.toddlers = toddlers;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getLuggage() {
		return luggage;
	}

	public void setLuggage(int luggage) {
		this.luggage = luggage;
	}

	public long getId() {
		return id;
	}
	
	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "ReservationInfo [id=" + id + ", flightId=" + flightId + ", toddlers=" + toddlers + ", children="
				+ children + ", adults=" + adults + ", luggage=" + luggage + ", price=" + price + "]";
	}

	



	

	
	
}
