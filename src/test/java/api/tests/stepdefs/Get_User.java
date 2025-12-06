package api.tests.stepdefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class Get_User {
    private Response response;

    @Given("the API base URL is set")
    public void set_base_url() {
        baseURI = "https://reqres.in";
    }

    @When("I request user details for user id {int}")
    public void request_user(int userId) {
        response = given().when().get("/api/users/" + userId);
    }

    @Then("the response status should be {int}")
    public void verify_status(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("the user first name should be {string}")
    public void verify_user_name(String firstName) {
        assertEquals(response.jsonPath().getString("data.first_name"), firstName);
    }
}
