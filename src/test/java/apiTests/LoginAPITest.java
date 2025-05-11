package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test
    public void positiveLoginTest_WithOfficialData() {
        Response response = RestAssured
            .given()
            .header("Content-Type", "application/json")
            .header("x-api-key", "reqres-free-v1")
            .body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }")
            .post("https://reqres.in/api/login");

        System.out.println("Positive Test (Official Data) Response: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
        Assert.assertTrue(response.getBody().asString().contains("token"), "Expected token in response");
    }

    @Test
    public void positiveLoginTest_WithUseCaseData() {
        Response response = RestAssured
            .given()
            .header("Content-Type", "application/json")
            .header("x-api-key", "reqres-free-v1")
            .body("{ \"email\": \"test@gmail.com\", \"password\": \"test\" }")
            .post("https://reqres.in/api/login");

        System.out.println("Positive Test (Use Case Data) Response: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
        Assert.assertTrue(response.getBody().asString().contains("token"), "Expected token in response");
    }

    @Test
    public void negativeLoginTest_MissingPassword() {
        Response response = RestAssured
            .given()
            .header("Content-Type", "application/json")
            .header("x-api-key", "reqres-free-v1")
            .body("{ \"email\": \"test@gmail.com\" }")
            .post("https://reqres.in/api/login");

        System.out.println("Negative Test Response: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 400, "Expected status code 400");
        Assert.assertTrue(response.getBody().asString().contains("Missing password"), "Expected missing password message");
    }
}
