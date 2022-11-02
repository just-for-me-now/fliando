package com.fliando.book.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Passenger {
	
	@Id
	@JsonProperty("id-card")
	public String idCard;

	@JsonProperty("first-name")
	public String firstName;

	@JsonProperty("last-name")
	public String lastName;
	
	public String nationality;
	
	public age age;

	public Passenger(String idCard, String firstName, String lastName, String nationality,
			com.fliando.book.model.age age) {
		this.idCard = idCard;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.age = age;
	}

	public Passenger() {}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public age getAge() {
		return age;
	}

	public void setAge(age age) {
		this.age = age;
	}
}
