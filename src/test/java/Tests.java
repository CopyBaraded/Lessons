import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Tests {
    @Test
    public void testGet() {
        given()
                .baseUri("https://postman-echo.com")
                .params("foo1", "bar1")
                .params("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .statusCode(200);
    }

    @Test
    public void testPost(){
        given()
                .baseUri("https://postman-echo.com")
                .headers("args.Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void testPatch(){
        given()
                .baseUri("https://postman-echo.com")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void testDel(){
        given()
                .baseUri("https://postman-echo.com")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}