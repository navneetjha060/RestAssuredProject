package Tests;

import static org.hamcrest.CoreMatchers.is;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Local_API_Testing {

	// @Test
	public void testGet() {

		RestAssured.baseURI = "http://localhost:3000/";
		given().get("students/1").then().statusCode(200).log().all();
	}

	@Test

	public void testPost() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "NavneetDemo");
		map.put("id", 6);

		System.out.println(map);

		JSONObject request = new JSONObject(map);
		System.out.println(request.toJSONString());

		given().body(request.toJSONString()).when().post("http://localhost:3000/students").then().statusCode(201).log()
				.all();

	}

}
