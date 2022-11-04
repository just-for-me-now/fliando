package com.fliando.users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserInfo {
	
	@Id
	private String name;
	
	private String pwd;
	
	

	public UserInfo(String name, String password) {
		this.name = name;
		this.pwd = password;
	}

	public UserInfo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return pwd;
	}

	public void setPassword(String password) {
		this.pwd = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + pwd + "]";
	}
	
	
	
	
}
