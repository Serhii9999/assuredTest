//package tests;
//
//import model.CreateUserRequest;
//import model.CreateUserResponse;
//import org.junit.jupiter.api.Test;
//
//import static io.restassured.RestAssured.given;
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//
//public class TestRegisterUser {
//
//    @Test
//    public void testCreateUser() {
//        CreateUserRequest rq = new CreateUserRequest();
//        rq.setName("name");
//        rq.setJob("job");
//
//        CreateUserResponse rs = given()
//                .spec(firstUsersPage())
//                .body(rq)
//                .when().post()
//                .then().extract().as(CreateUserResponse.class);
//
//        assertThat(rs)
//                .isNotNull()
//                .extracting(CreateUserResponse::getName)
//                .isEqualTo(rq.getName());
//    }
//}
