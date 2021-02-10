package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestsExamples {

	@Test
	public void test_1() {

		Response response = get("https://api.ratesapi.io/api/latest");

		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));

		response.getStatusCode();
		response.getTime();

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}
	
	@Test
	public void test_2() {
		
		baseURI = "https://api.ratesapi.io/api";
		given().
			get("/latest").
		then().
			statusCode(200).
			body("rates.BRL", equalTo(6.5248f))
			.log().all();
		
	}
	
	
	
	@Test
	public void test_3() {

		Response response = get("https://api.ratesapi.io/api/2010-01-12");

		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));

		response.getStatusCode();
		response.getTime();

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}
	
	@Test
	public void test_4() {
		
		baseURI = "https://api.ratesapi.io/api";
		given().
			get("/2010-01-12").
		then().
			statusCode(200).
			body("rates.BRL", equalTo(2.5309f))
			.log().all();
		
	}

	

}
