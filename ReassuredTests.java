package clientTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReassuredTests {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/api";
    }

    @Test
    public void testValidRequest() {
        String requestBody = "{\"idNumber\":\"9405240087083\",\"name\":\"John\",\"surname\":\"Doe\",\"bank\":\"Scrum Bank\",\"bankAccountNumber\":\"1234567890\"}";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/loan");
        response.then().statusCode(200);
    }

    @Test
    public void testInvalidIdNumber() {
        String requestBody = "{\"idNumber\":\"invalid\",\"name\":\"John\",\"surname\":\"Doe\",\"bank\":\"Scrum Bank\",\"bankAccountNumber\":\"1234567890\"}";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/loan");
        response.then().statusCode(400);
    }

    @Test
    public void testMolewaBankWarning() {
        String requestBody = "{\"idNumber\":\"9405240087083\",\"name\":\"John\",\"surname\":\"Doe\",\"bank\":\"Molewa Bank\",\"bankAccountNumber\":\"1234567890\"}";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/loan");
        ValidatableResponse body = response.then().statusCode(200);
    }
}
