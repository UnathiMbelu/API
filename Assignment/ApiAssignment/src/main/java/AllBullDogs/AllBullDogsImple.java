package AllBullDogs;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class AllBullDogsImple {
	
	public static RequestSpecification requestS;
	io.restassured.response.Response response;
		@Given("Dogs")
		public void dogs() {
		 
			RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://dog.ceo").build();
			requestS = given().spec(request);
		   
		}
	
	@When("user fetch all bull dogs")
	public void user_fetch_all_bull_dogs() {
		response = requestS.when().get("api/breeds/list/all");
	}

	
	@Then("{string} in response {string}")
	public void in_response(String message, String expected) {
	  
		JsonPath json = new JsonPath(response.asString());
		boolean bulldogs = json.getString(message).contains(expected);
		Assert.assertTrue(bulldogs);

		if (bulldogs) {
			System.out.println("\n" + expected + " breed found! " + json.getList("message.bulldog") + "\n");
		} else {
			System.out.println(expected + " breed does not exist in the list");
		}
		
	}
	

}
