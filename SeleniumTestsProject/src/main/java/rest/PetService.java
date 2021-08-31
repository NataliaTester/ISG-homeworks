package rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PetService {

    public Response createPet(String dog) {
        return RestAssured.given()
                .when().log().all()
                .header("Content-Type", "application/json")
                .body(dog)
                .post("https://petstore.swagger.io/v2/pet")
                .then().log().all()
                .extract().response();
    }

    public Response getPet(int id) {
        return RestAssured.given()
                .when().log().all()
                .header("Content-Type", "application/json")
                .get("https://petstore.swagger.io/v2/pet/" + id)
                .then().log().all()
                .extract().response();
    }

    public Response updatePet(String dog) {
        return RestAssured.given()
                .when().log().all()
                .header("Content-Type", "application/json")
                .body(dog)
                .put("https://petstore.swagger.io/v2/pet")
                .then().log().all()
                .extract().response();
    }

    public Response removePet(int id) {
        return RestAssured.given()
                .when().log().all()
                .header("Content-Type", "application/json")
                .delete("https://petstore.swagger.io/v2/pet/" + id)
                .then().log().all()
                .extract().response();
    }
}
