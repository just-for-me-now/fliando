package com.fliando.book.lib;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class InternalCommunications {
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

	public static void post(String address, String body) {
		given().contentType(ContentType.JSON).body(body).
		post(address);
	}
	
	public static boolean checkFlightExists(long id) {
		String path = "http://localhost:8084/flights/" + id;
		
		return given().contentType(ContentType.JSON).get(path).then().extract().statusCode() == 200;
		
	}

	public static int checkPrice(long flightId, int toddlers, int children, int adults, int luggage) {
		try {
			String path = "http://localhost:8082/price?flightId=" + flightId + "&toddlers=" + toddlers + "&children=" + children + "&adults=" + adults + "&luggage=" + luggage;
			
			//System.out.println((String) given().contentType(ContentType.JSON).get(path).then().extract().path("$"));
			return Integer.parseInt(given().contentType(ContentType.JSON).get(path).then().extract().asString());
		
		} catch(Exception e) {
			return -1;
		}
	}
}
