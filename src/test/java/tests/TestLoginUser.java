package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class TestLoginUser {


    final String rightCreds = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";
    final String wrongCreds = "{\"email\": \"345@gmail.com\", \"password\": \"12345\"}";
    final String wrongLogin = "{\"email\": \"peter@klaven\"}";

    @Test
    public void testLoginSuccessful() {

        given().contentType(ContentType.JSON).body(rightCreds).when().post("https://reqres.in/api/login").then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void testUnsuccessfulLoginWithoutPassword() {
        final String json = "{\"email\": \"peter@klaven\"}";

        given().contentType(ContentType.JSON).body(json).when().post("https://reqres.in/api/login").then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .body("error", equalTo("Missing password"));
    }

    @Test
    public void testUnsuccessfulLogin() {


        given().contentType(ContentType.JSON).body(wrongCreds).when().post("https://reqres.in/api/login").then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .body("error", equalTo("user not found"));
    }


}
