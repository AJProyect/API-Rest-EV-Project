package com.InditexProject.restApiIxPt.infrastructure;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerE2ETest {

    @LocalServerPort
    private int port;

    @Test
    public void testGetProductsOrdered() {
        RestAssured.baseURI = "http://localhost:" + port;

        given()
                .param("salesWeight", 0.5)
                .param("stockWeight", 0.3)
                .when()
                .get("/api/products/filtered")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void testFailGetProductsOrdered() {
        RestAssured.baseURI = "http://localhost:" + port;

        given()
                .param("salesWeight", -1)
                .param("stockWeight", 0.3)
                .when()
                .get("/api/products/filtered")
                .then()
                .assertThat()
                .statusCode(500);
    }

}

