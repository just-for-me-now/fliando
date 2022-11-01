package com.fliando.price.lib;

import com.fliando.price.model.Flight;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class InternalCommunication {

	public static Flight get(String address, long id) {
		return given().contentType(ContentType.JSON).get(address + "/" + id).as(Flight.class);
	}

	public static void post(String address, String body) {

		given().contentType(ContentType.JSON).body(body).post(address);

	}
}
