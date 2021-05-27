package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class TestDeleteUser {

    @Test
    public void testDeleteUserWithSpecifiedId() {
        RestAssured.given().when().delete("https://reqres.in/api/users/2").then().assertThat().statusCode(204);

    }


}

