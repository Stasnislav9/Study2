package com.example.tests;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostRequestTest extends BaseTest{
    @Test
    public void testPostRawText(){
        String textBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(textBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data",equalTo(textBody))
                .body("headers.content-type",equalTo("text/plain"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers",hasKey("user-agent"))
                .body("headers", hasKey("content-length"))
                .body("url",containsString("/post"));
    }

}
