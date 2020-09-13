package Dogs;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class ImpleDogs {
	
	public static RequestSpecification requestS;
	io.restassured.response.Response response;
		@Given("Dogs")
		public void dogs() {
			RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://dog.ceo").build();
			requestS = given().spec(request); 
		}
		@When("Select breed")
		public void select_breed() {
			response = requestS.when().get("api/breeds/image/random");   
		}
		@Then("{string} Display message {string}")
		public void display_message(String key, String value) {
			JsonPath json = new JsonPath(response.asString());
			Assert.assertEquals(json.getString(key), value);
			System.out.println("Random dog image: " + json.getString("message"));  
		}
		
		@Then("Show {string}")
		public void Show(String status){
			System.out.println(status);
			
		}

}
