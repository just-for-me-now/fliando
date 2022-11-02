package com.fliando.price.lib;

import static io.restassured.RestAssured.given;

import com.fliando.price.model.Flight;

import io.restassured.http.ContentType;

public class InternalCommunication {
	
	private static String address = "http://localhost:8085/logs";
	
	public static void log(String body) {
		try {
			given().contentType(ContentType.JSON).body(body).
			post(address);
		} catch(Exception e) {
			// TODO: Maybe log the fact that the other microservice is not available?
			// We mainly are interested on decoupling from failure to respond
		}
	}

	public static Flight get(String address, long id) {
		return given().contentType(ContentType.JSON).get(address + "/" + id).then().extract().as(Flight.class);
	}

	public static void post(String address, String body) {

		given().contentType(ContentType.JSON).body(body).post(address);

	}
}
