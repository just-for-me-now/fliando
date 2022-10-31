package com.fliando.flights;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class APItests {

	private static RequestSpecification requestSpec;
	
	@BeforeAll
	public static void setup() {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("htpp://localhost:8084")
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
	
}
