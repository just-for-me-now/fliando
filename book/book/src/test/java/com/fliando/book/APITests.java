package com.fliando.book;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fliando.book.model.Passenger;
import com.fliando.book.model.ReservationInfo;
import com.fliando.book.model.age;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

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
		
		ReservationInfo info = new ReservationInfo(9999L, List.of(new Passenger("12345678Z", "", "", "", age.ADULT)),0, false,100);
		given(requestSpec)
		.contentType(ContentType.JSON)
		.body(info)
		.when()
			.post("/book")
		.then()
			.assertThat().statusCode(400);
	}
	
	@Test
	public void Push_WrongPassengers_CannotAccessDestination() {
		
		ReservationInfo info = new ReservationInfo(1201L, List.of(),0, false,100);
		given(requestSpec)
		.contentType(ContentType.JSON)
		.body(info)
		.when()
			.post("/book")
		.then()
			.assertThat().statusCode(400);
	}
	
	@Test
	public void Push_NullPassengers_CannotAccessDestination() {
		
		ReservationInfo info = new ReservationInfo(1201L, null,0, false,100);
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
		ReservationInfo info = new ReservationInfo(1201L, List.of(new Passenger("" + Math.random(), "John", "Smith", "Guadalupean", age.ADULT)),0, false,20);
		given(requestSpec)
		.contentType(ContentType.JSON)
		.body(info)
		.when()
			.post("/book")
		.then()
			.assertThat().statusCode(201);
		
	}
	
	@Test
	public void Check_BackgroundCheck_403() {
		ReservationInfo info = new ReservationInfo(1201L, List.of(new Passenger("" + Math.random(), "Dick", "Rojas", "Guadalupean", age.ADULT)),0, false,20);
		given(requestSpec)
		.contentType(ContentType.JSON)
		.body(info)
		.when()
			.post("/book")
		.then()
			.assertThat().statusCode(403);
		
	}
	
	
}
