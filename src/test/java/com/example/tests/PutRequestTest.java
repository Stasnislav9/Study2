package com.example.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PutRequestTest extends BaseTest {
    @Test
    public void testPutRequest(){
        String textBody = "This is expected to be sent back as part of response body.";
        given()
                .contentType("text/plain")
                .body(textBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data",equalTo(textBody))
                .body("headers.content-type",equalTo("text/plain"))
                .body("headers",hasKey("user-agent"))
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers",hasKey("content-length"))
                .body("url",containsString("/put"));

    }
}
