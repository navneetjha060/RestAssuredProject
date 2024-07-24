package Tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidationTest {

	@Test
	public void testGet() {

		given().get("https://reqres.in/api/users/2").then().statusCode(200).body(matchesJsonSchemaInClasspath("schema.json")).log().all();
	}

}
