package pages;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Pages {

    public static final String mainPage = "https://reqres.in";
    public static final String firstUserPage = "https://reqres.in/api/users?page=1";
    public static final String secondUserPage = "https://reqres.in/api/users?page=2";
    public static final String firstOrderPage = "https://reqres.in/api/orders?page=1";
    public static final String secondOrderPage = "https://reqres.in/api/orders?page=2";
    public static final String absentPage = "https://reqres.in/aaa";




//     private static final RequestSpecification mainPage = new RequestSpecBuilder()
//            .setBaseUri("https://reqres.in/")
//            .setContentType(ContentType.JSON).build();
//
//    private static final RequestSpecification firstUsersPage = new RequestSpecBuilder()
//            .setBaseUri("https://reqres.in/api").setBasePath("/users?page=1")
//            .setContentType(ContentType.JSON).build();
//
//    private static final RequestSpecification secondUsersPage = new RequestSpecBuilder()
//            .setBaseUri("https://reqres.in/api").setBasePath("/users?page=2")
//            .setContentType(ContentType.JSON).build();
//
//    private static final RequestSpecification firstOrdersPage = new RequestSpecBuilder()
//            .setBaseUri("https://reqres.in/api").setBasePath("/orders?page=1")
//            .setContentType(ContentType.JSON).build();
//
//    private static final RequestSpecification secondOrdersPage = new RequestSpecBuilder()
//            .setBaseUri("https://reqres.in/api").setBasePath("/orders?page=2")
//            .setContentType(ContentType.JSON).build();
//
//    public static RequestSpecification mainPage() {
//        return mainPage;
//    }
//
//    public static RequestSpecification firstUsersPage() {
//        return firstUsersPage;
//    }
//
//    public static RequestSpecification secondUsersPage() {
//        return secondUsersPage;
//    }
//
//    public static RequestSpecification firstOrdersPage() {
//        return firstOrdersPage;
//    }
//
//    public static RequestSpecification secondOrdersPage() {
//        return secondOrdersPage();
//    }

}
