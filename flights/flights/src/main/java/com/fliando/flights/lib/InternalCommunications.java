package com.fliando.flights.lib;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class InternalCommunications {
	public static void post(String address, String body) {
		try {
			given().contentType(ContentType.JSON).body(body).
			post(address);
		} catch(Exception e) {
			// TODO: Maybe log the fact that the other microservice is not available?
			// We mainly are interested on decoupling from failure to respond
		}
	}
}
