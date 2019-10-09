package restassured.poc.learning;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleGet {

	@Test
	public void test() {
		String url = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri(url);
		Response response = requestSpec.request(Method.GET, "/Hyderabad");
		
		System.out.println("Vinit: " + response.getBody().asString());
		
	}
}
