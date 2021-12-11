package services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.GetToken;
import models.create.CreateBooking;

import static io.restassured.RestAssured.given;

public class BookerService {

    public static final String BOOKS_BASE_PATH = "/booking";



    public Response createToken(GetToken getToken, RequestSpecification requestSpec) {
        return given()
                .spec(requestSpec)
                .body(getToken)
                .when()
                .post("/auth")
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response();
    }

    public String createTokenAndGetToken(RequestSpecification requestSpec) {
        return given()
                .spec(requestSpec)
                .body(GetToken.builder().build())
                .when()
                .post("/auth")
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response().path("token");
    }

    public Response createBooking(CreateBooking createBooking, RequestSpecification requestSpec, ResponseSpecification responseSpec){
        return given()
                .spec(requestSpec)
                .basePath(BOOKS_BASE_PATH)
                .body(createBooking)
                .when()
                .post()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .spec(responseSpec)
                .extract().response();
    }

    public Integer createBookingAndGetId(RequestSpecification requestSpec){
        return given()
                .spec(requestSpec)
                .basePath(BOOKS_BASE_PATH)
                .body(CreateBooking.builder().build())
                .when()
                .post()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response().path("bookingid");
    }

    public Response deleteBooking(Integer id, String token, RequestSpecification requestSpec, ResponseSpecification responseSpec){
        return given()
                .spec(requestSpec)
                .header("Cookie","token="+token)
                .basePath(BOOKS_BASE_PATH)
                .pathParam("id", id)
                .when()
                .delete("/{id}")
                .then()
                .assertThat()
                .log().ifValidationFails()
                .spec(responseSpec)
                .extract().response();
    }

}
