package com.fliando.flights.lib;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class InternalCommunications {
	public static void post(String address, String body) {
		System.out.println(given().contentType(ContentType.JSON).body(body).
		post(address).asString());
	}
}
