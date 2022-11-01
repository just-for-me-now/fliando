package com.fliando.book.lib;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class InternalCommunications {

	public static void post(String address, String body) {
		given().contentType(ContentType.JSON).body(body).
		post(address);
	}
}
