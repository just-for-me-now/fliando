package com.fliando.flights;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class APItests {

	private static RequestSpecification requestSpec;
	private static String dateAsString;
	
	@BeforeAll
	public static void setup() {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("http://localhost:8084")
				.build();
		LocalDate date = LocalDate.now().plusDays(15);
		dateAsString = date.toString(); 
		
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
		System.out.println(dateAsString);
		
		given(requestSpec)
		.when()
			.get("/origins/9/destinations/1/dates/" + dateAsString)
		.then()
			.assertThat()
			.statusCode(400);
		
	}
	
	@Test
	public void GetDates_WrongDestination_400() {

		given(requestSpec)
		.when()
			.get("/origins/1/destinations/10/dates/" + dateAsString)
		.then()
			.assertThat()
			.statusCode(400);
		
	}
	
	@Test
	public void GetDates_CorrectRequest_ReturnsList() {

		given(requestSpec)
		.when()
			.get("/origins/1/destinations/1/dates/" + dateAsString)
		.then()
			.assertThat()
			.statusCode(200);
		
	}
	
	@Test
	public void GetFlight_CorrectRequest_ReturnsFlight() {

		given(requestSpec)
		.when()
			.get("/flights/1")
		.then()
			.assertThat()
			.statusCode(200);
		
	}
	
	@Test
	public void GetFlight_NoFlight_404() {

		given(requestSpec)
		.when()
			.get("/flights/10000")
		.then()
			.assertThat()
			.statusCode(404);
		
	}
	
}
