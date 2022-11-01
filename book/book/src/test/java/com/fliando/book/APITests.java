package com.fliando.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fliando.book.model.ReservationInfo;

import io.restassured.builder.RequestSpecBuilder;
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
	public void Push_WrongDestination_CannotAccessDestination() {
		//flight id; toddlers; children; adults; luggage;
		ReservationInfo info = new ReservationInfo(404,0,0,1,1);
		given(requestSpec)
		.when()
			.body(info)
			.post("/book")
		.then()
			.assertThat().statusCode(400);
	}
	
	@Test
	
}
