package PetConfirmImple;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class ConfirmPetID {

	public static RequestSpecification requestS;
	io.restassured.response.Response response;
	
	Response newResponse;
	
	RequestSpecification newRequestSpec;
	ResponseSpecification responseS;
	
		@Given("add pet payload")
		public void add_pet_payload() {
			RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2")
					.setContentType(ContentType.JSON).build();
			responseS = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			requestS = given().spec(request).body("{\r\n" + 
					"  \"id\": 0,\r\n" + 
					"  \"category\": {\r\n" + 
					"    \"id\": 12,\r\n" + 
					"    \"name\": \"string\"\r\n" + 
					"  },\r\n" + 
					"  \"name\": \"doggie\",\r\n" + 
					"  \"photoUrls\": [\r\n" + 
					"    \"string\"\r\n" + 
					"  ],\r\n" + 
					"  \"tags\": [\r\n" + 
					"    {\r\n" + 
					"      \"id\": 0,\r\n" + 
					"      \"name\": \"string\"\r\n" + 
					"    }\r\n" + 
					"  ],\r\n" + 
					"  \"status\": \"available\"\r\n" + 
					"}");
		    
		}

		
		@When("user calls add pet with POST HTTP request")
		public void user_calls_add_pet_with_post_http_request() {
			response = requestS.when().post("pet").then().spec(responseS).extract().response();
		}

		@Then("the API call processes successfully with status code {int}")
		public void the_api_call_processes_successfully_with_status_code(int code) {
			Assert.assertEquals(response.getStatusCode(), code);
		}

		@And("{string} in response body is {string}")
		public void in_response_body_is(String status, String expected) {
			JsonPath json = new JsonPath(response.asString());
			Assert.assertEquals(expected, json.getString(status));
		}

		@And("pet object in add pet call is the same object in respons9")
		public void pet_object_in_add_pet_call_is_the_same_object_in_respons9() {
			JsonPath json = new JsonPath(response.asString());
			String pet = requestS.when().get("pet/" + json.getString("id"))
					.then().assertThat().statusCode(200).log().all().extract().response().asString();

			System.out.println("created pet : \n" + pet);
		}




}
