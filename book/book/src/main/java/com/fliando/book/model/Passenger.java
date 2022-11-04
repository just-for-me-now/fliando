package com.fliando.book.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Passenger {
	
	@Id
	@JsonProperty("id-card")
	public String id;

	@JsonProperty("first-name")
	public String name;

	@JsonProperty("last-name")
	public String surname;
	
	public String nationality;
	
	public age age;

	public Passenger(String id, String name, String surname, String nationality,
			com.fliando.book.model.age age) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.nationality = nationality;
		this.age = age;
	}

	public Passenger() {}

	public String getIdCard() {
		return id;
	}

	public void setIdCard(String idCard) {
		this.id = idCard;
	}

	public String getFirstName() {
		return name;
	}

	public void setFirstName(String firstName) {
		this.name = firstName;
	}

	public String getLastName() {
		return surname;
	}

	public void setLastName(String lastName) {
		this.surname = lastName;
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
