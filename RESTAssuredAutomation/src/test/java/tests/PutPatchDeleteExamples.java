package tests;

import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {

	@Test
	public void testGet() {

		baseURI = "https://api.ratesapi.io/api";

		given().
			get("/latest").
		then().
			statusCode(200).
			body("rates.GBP", equalTo(0.87538f));
	
	}


	@Test
	public void testPut() {

		JSONObject request = new JSONObject();

		request.put("RUB", "1,99");
		request.put("date", 2022-11-02);

		System.out.println(request.toJSONString());

		baseURI = "https://api.ratesapi.io/api";

		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/latest").
		then().
			statusCode(405).
			log().all();
	}


	@Test
	public void testPatch() {

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
			patch("/latest").
		then().
			statusCode(405).
			log().all();
	}


	@Test
	public void testDelete() {

		baseURI = "https://api.ratesapi.io/api";
	
		when().
			delete("/latest").
		then().
			statusCode(405).
			log().all();
	}




}
