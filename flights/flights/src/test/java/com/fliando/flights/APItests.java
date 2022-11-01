package com.fliando.flights;

import static io.restassured.RestAssured.given;

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
	
}
