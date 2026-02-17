package com.example.tests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequestTest extends BaseTest {

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers",hasKey("user-agent"))
                .body("url",containsString("foo1=bar1"))
                .body("url",containsString("foo2=bar2"))
                .body("url", containsString("/get"));
    }
}