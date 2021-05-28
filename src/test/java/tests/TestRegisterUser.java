package tests;

import io.restassured.http.ContentType;
import model.UserRequest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;




public class TestRegisterUser {

    final String wrongEmail = "{\"email\": \"sydney@fife\"}";
    UserRequest request = UserRequest.builder().id(100).firstName("Ivan").lastName("Petrov").email("123@gmail.com").build();

    @Test
    public void testCreatedUserIsNotNull() {
        assertThat(request).isNotNull().extracting(UserRequest::getId).isEqualTo(100);
        assertThat(request).isNotNull().extracting(UserRequest::getFirstName).isEqualTo("Ivan");
        assertThat(request).isNotNull().extracting(UserRequest::getLastName).isEqualTo("Petrov");
        assertThat(request).isNotNull().extracting(UserRequest::getEmail).isEqualTo("123@gmail.com");

    }

    @Test
            public void testAddUser() {
        given().body(request.toString()).when().post("https://reqres.in/api/users").then().statusCode(201);

    }

    @Test
    public void testRegisterUserUnsuccessful() {

        given().contentType(ContentType.JSON).body(wrongEmail).when().post("https://reqres.in/api/register").then().statusCode(400)
                .contentType(ContentType.JSON);
    }






}
