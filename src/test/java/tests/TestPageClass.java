package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static pages.Pages.*;

public class TestPageClass {


    @Test
    public void testMainPageToExist() {
        given().get(mainPage).then().statusCode(200);
    }

    @Test
    public void testUsersPageToExist() {
        given().get(firstUserPage).then().statusCode(200);
    }

    @Test
    public void testUsersPage2ToExist() {
        given().get(secondUserPage).then().statusCode(200);
    }

    @Test
    public void testOrdersPageToExist() {
        given().get(firstOrderPage).then().statusCode(200);
    }

    @Test
    public void testOrdersPage2ToExist() {
        given().get(secondUserPage).then().statusCode(200);
    }

    @Test
    public void testFailToGetAbsentPage() {
        given().get(absentPage).then().statusCode(404);
    }


}
