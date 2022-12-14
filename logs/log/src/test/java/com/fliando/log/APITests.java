package com.fliando.log;

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
                .setBaseUri("http://localhost:8085")
                .build();
    }
	
	@Test
	public void Push_CorrectData_Succesful() {
		given(requestSpec)
		.when()
			.body("Test log")
			.post("/logs")
		.then()
			.assertThat()
			.statusCode(201);
	}
	
	@Test
	public void Get_RetreiveAllData_Succesful() {
		given(requestSpec)
		.when()
			.get("/logs")
		.then()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON);
	}
	
	
}
