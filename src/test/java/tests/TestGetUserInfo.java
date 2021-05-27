package tests;

import model.UserModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static pages.Pages.firstUserPage;
import static pages.Pages.secondUserPage;

public class TestGetUserInfo {


    @Test
    public void testFirstUserIdToBeEqualTo1OnFirstPage() {
        given().get(firstUserPage).then().statusCode(200).body("data.id[0]", equalTo(1));


    }

    @Test
    public void testFirstUserIdToBeEqualTo7OnSecondPage() {
        given().get(secondUserPage).then().statusCode(200).body("data.id[0]", equalTo(7));


    }

    @Test
    public void testFewNamesToContain() {
        given().get(firstUserPage).then().
                statusCode(200)
                .body("data.first_name", hasItems("George", "Janet", "Emma"));
    }


    @Test
    public void testUserIdDoesntExist() {
        List<UserModel> list = given().get(firstUserPage).then().statusCode(200)
                .extract().jsonPath().getList("data", UserModel.class);
        assertThat(list).extracting(UserModel::getId).doesNotContain(10);
    }

    @Test
    public void testUserFirstNameDoesntExist() {
        List<UserModel> list = given().get(firstUserPage).then().statusCode(200)
                .extract().jsonPath().getList("data", UserModel.class);
        assertThat(list).extracting(UserModel::getFirstName).doesNotContain("Kevin");
    }

    @Test
    public void testUserIdsToExist() {
        List<UserModel> list = given().get(firstUserPage).then().statusCode(200)
                .extract().jsonPath().getList("data", UserModel.class);
        assertThat(list).extracting(UserModel::getId).contains(1);
        assertThat(list).extracting(UserModel::getId).contains(2);
        assertThat(list).extracting(UserModel::getId).contains(3);
        assertThat(list).extracting(UserModel::getId).contains(4);
        assertThat(list).extracting(UserModel::getId).contains(5);
        assertThat(list).extracting(UserModel::getId).contains(6);
    }

    @Test
    public void testUserEmailsToExist() {
        List<UserModel> list = given().get(firstUserPage).then().statusCode(200)
                .extract().jsonPath().getList("data", UserModel.class);
        assertThat(list).extracting(UserModel::getEmail).contains("george.bluth@reqres.in");
        assertThat(list).extracting(UserModel::getEmail).contains("janet.weaver@reqres.in");
        assertThat(list).extracting(UserModel::getEmail).contains("emma.wong@reqres.in");
        assertThat(list).extracting(UserModel::getEmail).contains("eve.holt@reqres.in");
        assertThat(list).extracting(UserModel::getEmail).contains("charles.morris@reqres.in");
        assertThat(list).extracting(UserModel::getEmail).contains("tracey.ramos@reqres.in");
    }

    @Test
    public void testUserFirstNamesToExist() {
        List<UserModel> list = given().get(firstUserPage).then().statusCode(200)
                .extract().jsonPath().getList("data", UserModel.class);
        assertThat(list).extracting(UserModel::getFirstName).contains("George");
        assertThat(list).extracting(UserModel::getFirstName).contains("Janet");
        assertThat(list).extracting(UserModel::getFirstName).contains("Emma");
        assertThat(list).extracting(UserModel::getFirstName).contains("Eve");
        assertThat(list).extracting(UserModel::getFirstName).contains("Charles");
        assertThat(list).extracting(UserModel::getFirstName).contains("Tracey");
    }

    @Test
    public void testUserLastNamesToExist() {
        List<UserModel> list = given().get(firstUserPage).then().statusCode(200)
                .extract().jsonPath().getList("data", UserModel.class);
        assertThat(list).extracting(UserModel::getLastName).contains("Bluth");
        assertThat(list).extracting(UserModel::getLastName).contains("Weaver");
        assertThat(list).extracting(UserModel::getLastName).contains("Wong");
        assertThat(list).extracting(UserModel::getLastName).contains("Holt");
        assertThat(list).extracting(UserModel::getLastName).contains("Morris");
        assertThat(list).extracting(UserModel::getLastName).contains("Ramos");
    }

    @Test
    public void testUserAvatarsToExist() {
        List<UserModel> list = given().get(firstUserPage).then().statusCode(200)
                .extract().jsonPath().getList("data", UserModel.class);
        assertThat(list).extracting(UserModel::getAvatar).contains("https://reqres.in/img/faces/1-image.jpg");
        assertThat(list).extracting(UserModel::getAvatar).contains("https://reqres.in/img/faces/2-image.jpg");
        assertThat(list).extracting(UserModel::getAvatar).contains("https://reqres.in/img/faces/3-image.jpg");
        assertThat(list).extracting(UserModel::getAvatar).contains("https://reqres.in/img/faces/4-image.jpg");
        assertThat(list).extracting(UserModel::getAvatar).contains("https://reqres.in/img/faces/5-image.jpg");
        assertThat(list).extracting(UserModel::getAvatar).contains("https://reqres.in/img/faces/6-image.jpg");
    }


}

