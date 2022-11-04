package com.fliando.users;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class APITests {
	private static RequestSpecification requestSpec;

	@BeforeAll
	public static void setup() {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("http://localhost:08087")
				.build();
	}
	
	@Test
	public void postCorrectUsernameAndPassword() {
		String username = "wrongusername";
		String password ="wrongpassword";
		
		given(requestSpec)
		.contentType(ContentType.JSON)
		
		
	}
	@Test
	public void postIncorrectUsername() {
		
	}
	@Test
	public void postIncorrectPassword() {
		
	}
	
}
