package com.fliando.flights;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class APItests {

	private static RequestSpecification requestSpec;
	
	@BeforeAll
	public static void setup() {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("http://localhost:8084")
				.build();
	}
	
	@Test
	public void Get_RetreiveAllOrigins_Succesful() {
		given(requestSpec)
		.when()
			.get("/origins")
		.then()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON);
		
	}
	
	@Test
	public void Get_RightOrigin_Succesful() {
		
		given(requestSpec)
		.when()
			.get("/origins/1/destinations")
		.then()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON);
	}
	
	@Test
	public void Get_WrongOrigin_400() {
		
		given(requestSpec)
		.when()
			.get("/origins/9/destinations")
		.then()
			.assertThat()
			.statusCode(400);
	}
	
	@Test
	public void GetDates_WrongOrigin_400() {
		
		given(requestSpec)
		.when()
			.get("origins/9/destinations/1/dates")
		.then()
			.assertThat()
			.statusCode(400);
		
	}
	
	@Test
	public void GetDates_WrongDestination_400() {

		given(requestSpec)
		.when()
			.get("origins/1/destinations/10/dates")
		.then()
			.assertThat()
			.statusCode(400);
		
	}
	
	@Test
	public void GetDates_CorrectRequest_ReturnsList() {

		given(requestSpec)
		.when()
			.get("origins/1/destinations/1/dates")
		.then()
			.assertThat()
			.statusCode(200);
		
	}
	
}
