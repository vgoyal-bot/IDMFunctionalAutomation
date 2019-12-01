package restassured.poc.learning;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.matcher.ResponseAwareMatcher;
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
	
	@Test
	public void test1() {
		String url = "http://restapi.demoqa.com/utilities/weather/city";
		
		Response response = RestAssured.given().baseUri(url).accept(ContentType.JSON).get("/Hyderabad");
		
		System.out.println("Vinit: " + response.getBody().asString());
//		Assert.assertEquals(response.path("City"), "Hyderabad");
		
//		System.out.println("all headers: " +response.getHeaders());
		
		response.then().body("City", Matchers.is("Hyderabad"));
		response.thenReturn().path("City", "Hyderabad");
		
	}
	
	// to create json dynamically using java object using org.json
	@Test
	public void test2() {
		JSONObject obj = new JSONObject();
		
	      obj.put("name", "foo");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));

	      System.out.print(obj);
	}

	// to create json dynamically using java object using google.gson
	@Test
	public void test3() {
		// Create new JSON Object
		JsonObject person = new JsonObject();
		person.addProperty("firstName", "Sergey");
		person.addProperty("lastName", "Kargopolov");
		System.out.println(person.toString());
		
		// Create JSON Array 
		JsonArray languages = new JsonArray();
		languages.add("Russian");
		languages.add("English");
		languages.add("French");
		
		}
}
