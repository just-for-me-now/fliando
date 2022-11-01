package com.fliando.log.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Log {
	@Id
	@GeneratedValue
	private long id;
	
	private String message;

	public Log(String message) {
		super();
		this.message = message;
	}

	public Log() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", message=" + message + "]";
	}
	
	
}
