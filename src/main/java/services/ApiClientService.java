package services;

import config.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ApiClientService {

    static String BASE_URL = ConfigManager.getProperty("base.url");

    public static Response getApiData(String url){
        Response response = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().response();
        return response;
    }

}
