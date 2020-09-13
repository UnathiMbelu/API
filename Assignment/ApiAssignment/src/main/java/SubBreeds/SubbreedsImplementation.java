package SubBreeds;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import java.util.List;

public class SubbreedsImplementation {
	
	public static RequestSpecification requestS;
	io.restassured.response.Response response;
	
	@Given("Fetch bulldog breed list")
	public void fetch_bulldog_breed_list() {
		RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://dog.ceo").build();
		requestS = given().spec(request);
	}

	@When("user calls bulldogBreeds")
	public void user_calls_bulldogBreeds() {
		response = requestS.when().get("api/breed/bulldog/list");
	}

	@Then("response body list")
	public void response_body_list() {

		JsonPath json = new JsonPath(response.asString());

		System.out.println("Bulldog sub-breeds: " + json.getList("message"));

	}

	@Then("retrieve images of each sub-breed")
	public void retrieve_images_of_each_sub_breed() {

		JsonPath json = new JsonPath(response.asString());
		int breedSize = json.getInt("message.size()");

		for (int i = 0; i < breedSize; i++) {
			System.out.println(json.getString("message[" + i + "]") + " bulldogs : " + getImages(json.getString("message[" + i + "]")));
		}
	}

	private List<String> getImages(String subbreed) {
		
		Response onse = requestS.when().get("api/breed/bulldog/" + subbreed + "/images");
		JsonPath json = new JsonPath(onse.asString());
		
		return json.getList("message");
	}

}
