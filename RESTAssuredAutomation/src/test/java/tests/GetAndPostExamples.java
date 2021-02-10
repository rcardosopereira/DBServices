package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {
	
	@Test
	public void testGetOne() {
		
		baseURI = "https://api.ratesapi.io/api";
		
		given().
		get("/latest").
	then().
		statusCode(200).
		body("rates.GBP", equalTo(0.87538f));
		//body("date", equalTo(Arrays.asList(date)));
		//body("date", equalTo(2021-02-05)).log().all().
		//body("data", hasItem("2021-02-05"));
		
	}
	
	
	@Test
	public void testGetTwo() {
		
		baseURI = "https://api.ratesapi.io/api";
		
		given().
		get("/2010-01-12").
	then().
		statusCode(200).
		body("rates.GBP", equalTo(0.8972f));
	
		
	}
	
	
	@Test
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//map.put("RUB", "1,99");
		//map.put("date", 2022-11-02);
		// map.put("date", "2022-11-02");
		
		//System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("RUB", "1,99");
		request.put("date", 2022-11-02);
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://api.ratesapi.io/api";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON)
			.accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/latest").
		then().
			statusCode(201).
			log().all();
		
		
	}
	
	
	

}
