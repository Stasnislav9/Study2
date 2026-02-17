package com.example.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostFormDataTest extends BaseTest{
    @Test
    public void testPostFormData(){
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParams("foo1","bar1")
                .formParams("foo2","bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1",equalTo("bar1"))
                .body("form.foo2",equalTo("bar2"))
                .body("json.foo1",equalTo("bar1"))
                .body("json.foo2",equalTo("bar2"))
                .body("headers.content-type",containsString("/x-www-form-urlencoded"))
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers",hasKey("user-agent"))
                .body("url",containsString("/post"));
    }

}
