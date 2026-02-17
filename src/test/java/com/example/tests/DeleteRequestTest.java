package com.example.tests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequestTest extends BaseTest {

    @Test
    public void testDeleteRequest() {
        String textBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(textBody)
                .when()
                .delete("/delete")  // Метод DELETE
                .then()
                .statusCode(200)
                // Проверяем данные
                .body("data", equalTo(textBody))
                // Проверяем заголовки
                .body("headers.content-type", equalTo("text/plain"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers", hasKey("user-agent"))
                // Проверяем URL
                .body("url", containsString("/delete"));  // URL с /delete
    }
}