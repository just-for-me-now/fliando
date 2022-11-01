package com.fliando.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fliando.book.model.ReservationInfo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.specification.RequestSpecification.*;

import static io.restassured.RestAssured.*;

public class APITests {

	private static RequestSpecification requestSpec;
	
	@BeforeAll
	public static void setup() {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("http://localhost:8086")
				.build();
	}
	
	@Test
	public void Push_WrongDestination_CannotAccessDestination() {
		//flight id; toddlers; children; adults; luggage;
		ReservationInfo info = new ReservationInfo(40400,0,0,1,1,100);
		given(requestSpec)
		.contentType(ContentType.JSON)
		.body(info)
		.when()
			.post("/book")
		.then()
			.assertThat().statusCode(400);
	}
	
	@Test
	public void Check_Correct_Price_Value_Return_Correct_Value() {
		ReservationInfo info = new ReservationInfo(40400,0,0,1,1,100);
		
	}
	
	
}
