package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class APITest {
    @Test
    public void testGetUser() {
        Response response = RestAssured
                .given()
                .baseUri("https://reqres.in")  // sample public API
                .when()
                .get("/api/users/2");

        response.prettyPrint();
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("data.first_name"), "Janet");
    }
}
