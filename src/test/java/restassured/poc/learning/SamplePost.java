package restassured.poc.learning;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SamplePost {

	@Test
	public void samplePost() throws FileNotFoundException {
		JsonReader jsonReader = Json.createReader(new FileReader("resources/sample1.json"));
		
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("http://restapi.demoqa.com/customer/register");
		requestSpec.body(jsonReader.readObject().toString());
		
		Response response = requestSpec.request(Method.POST);
		System.out.println("response: " +response.asString());
		
		response.getHeaders();
		response.jsonPath().get("");
	}
}
