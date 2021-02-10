//https://www.liquid-technologies.com/online-json-to-schema-converter
package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JSONSchemaValidator {
	
	
	
	@Test
	public void testGet() {
		
		baseURI = "https://api.ratesapi.io/api";
		
		given().
		get("/2010-01-12").
	then().
		assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200);

	}

}
