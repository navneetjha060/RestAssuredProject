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

public class Test_Demo_One {

	// @Test(priority = 1)
	public void testOne() {

		String expected = "200";
		Response actual = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(actual.getStatusCode());
		Assert.assertEquals(expected, expected);
	}

	// @Test(priority = 2)
	public void testTwo() {

		RestAssured.baseURI = "https://reqres.in/api/";
		given().get("users?page=2").then().statusCode(200).body("data[2].first_name", is("Tobias")).log().all();
	}

	// @Test(priority = 3)
	public void testThree() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "morpheus");
		map.put("job", "leader");

		System.out.println(map);

		JSONObject request = new JSONObject(map);
		System.out.println(request.toJSONString());

		given().body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log()
				.all();

	}

	//@Test(priority = 4)
	public void testFour() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "morpheus");
		map.put("job", "leader");

		System.out.println(map);

		JSONObject request = new JSONObject(map);
		System.out.println(request.toJSONString());

		given().body(request.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log()
				.all();

	}

	//@Test(priority = 5)
	public void testFive() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "morpheus");
		map.put("job", "leader");

		System.out.println(map);

		JSONObject request = new JSONObject(map);
		System.out.println(request.toJSONString());

		given().body(request.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log()
				.all();

	}
	
	
	@Test(priority = 6)
	public void testSix() {
		
		given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}
	
	
	

}
