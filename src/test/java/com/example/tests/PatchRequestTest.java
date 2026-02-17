package com.example.tests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PatchRequestTest extends BaseTest {

    @Test
    public void testPatchRequest() {
        String textBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(textBody)
                .when()
                .patch("/patch")  // Метод PATCH
                .then()
                .statusCode(200)
                // Проверяем данные
                .body("data", equalTo(textBody))
                // Проверяем заголовки
                .body("headers.content-type", equalTo("text/plain"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers", hasKey("user-agent"))
                // Проверяем URL
                .body("url", containsString("/patch"));  // URL с /patch
    }
}