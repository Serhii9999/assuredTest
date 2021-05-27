package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class TestUpdateUser {


    @Test
    public void testUpdateUserWithSpecifiedIdAndCheckThatCreatedTimeIsNotNull() {
        String string = "{\"first_name\": \"Kirill\", \"last_name\": \"Kovalenko\"}";
        String resp = RestAssured.given().request().accept(ContentType.JSON)
                .body(string).when()
                .put("https://reqres.in/api/users/2").then().assertThat().statusCode(200).and()
                .contentType(ContentType.JSON).extract().response().asString();

        String updatedAt = JsonPath.from(resp).getString("updatedAt");
        assertThat(updatedAt!=null);
        System.out.println(updatedAt);
    }
}
