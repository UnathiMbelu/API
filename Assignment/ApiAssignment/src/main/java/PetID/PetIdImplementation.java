package PetID;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import org.junit.Assert;
public class PetIdImplementation {
	

	public static RequestSpecification requestS;
	io.restassured.response.Response response;
		@Given("Fetch pets available")
		public void fetch_pets_available_payload() {
			RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet").build();
			requestS = given().spec(request);
		}



		@When("user calls findPets {string} with GET HTTP request method")
		public void user_calls_find_pets_with_get_http_request_method(String status) {
			response = requestS.when().log().all().get("findByStatus?status=" + status);
		    
		}
		@Then("{string} should be {string} and category {string} must be {string} in response body")
		public void should_be_and_category_must_be_in_response_body(String name, String expected, String id, String value) {
			JsonPath json = new JsonPath(response.asString());
			boolean pet = json.getString(name).contains(expected);
			boolean category = json.getString("category." + id).contains(value);
			Assert.assertTrue(pet && category);

			if (pet && category) {
				System.out.println("\nPet name'" + expected + "' with category id " + value + " was found!\n");
			} else {
				System.out.println("Pet name'" + expected + "' with category id " + value + " does not exist in the list!");
			}
		
		}
		@Then("the call processes successful with status code {int}")
		public void the_call_processes_successful_with_status_code(int code) {
			Assert.assertEquals(response.getStatusCode(), code);
			
	
		}




}
