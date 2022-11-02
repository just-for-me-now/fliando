package com.fliando.price;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class ApiTests {
	
	private static RequestSpecification requestSpec;
	
	@BeforeAll
	public static void setup() {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("http://localhost:8082")
				.build();
	}

	@Test
	public void Get_RetreiveAllParams_ShowCorrectPrice() {
		//GET /price?flightId={id}&toddlers=0&children=0&adults=1&luggage=3
		given(requestSpec)		
		.when()
			.get("/price?flightId=1&toddlers=1&children=0&adults=1&luggage=0")
		.then()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("$.price", equalTo("50"));
	}
	
	@Test
	public void Get_RetreiveAllParams_ReturnsBadRequest() {
		given(requestSpec)		
		.when()
			.get("/price?flightId=0&toddlers=0&children=0&adults=0&luggage=0")
		.then()
			.assertThat()
			.statusCode(400)
			.contentType(ContentType.JSON);
		
	}
	
	@Test
	public void Get_RetreiveWrongFlight_ReturnBadRequest() {
		given(requestSpec)
		.when()
			.get("/price?flightId=81312313534534531&toddlers=0&children=0&adults=1&luggage=0")
		.then()
			.assertThat()
			.statusCode(400)
			.contentType(ContentType.JSON);
	}
	
	
}
