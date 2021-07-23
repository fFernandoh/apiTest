package api;

import io.cucumber.datatable.DataTable;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ReqresApi {

    private final String BASE_URL = "https://reqres.in/";
    private final String UPDATE_USER = "api/users/{n}";
    private final String GET_SINGLE_USER = "api/users/{n}";
    private final String GET_USER_LIST = "api/users?page={n}";
    private final String REGISTER_SUCESSFUL = "api/register";
    private final String REGISTER_NEW_USER = "api/users";

    public Response updateUser(int n) {
        RequestSpecification request = given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .pathParam("n", n).log().all();

        Response response = request.patch(BASE_URL + UPDATE_USER);
        response.then().statusCode(HttpStatus.SC_OK);

        return response;
    }

    public Response getSingleUser(String n) {
        RequestSpecification request = given()
                .pathParam("n", n);

        Response response = request.get(BASE_URL + GET_SINGLE_USER);
        response.then().statusCode(HttpStatus.SC_OK);

        return response;

    }

    public Response getUserList(int n) {
        RequestSpecification request = given().log().all()
                .pathParam("n", n);

        Response response = request.get(BASE_URL + GET_USER_LIST);
        response.then().statusCode(HttpStatus.SC_OK);

        return response;
    }

    public Response postRegisterSucessful() {
        RequestSpecification request = given().log().all()
                .contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}");

        Response response = request.post(BASE_URL + REGISTER_SUCESSFUL);
        response.then().statusCode(HttpStatus.SC_OK);

        return response;
    }

    public Response addNewUser(DataTable usersTest){
        RequestSpecification request = given()
                .contentType("application/json; charset=utf-8");

        Response response = request.post(BASE_URL + REGISTER_NEW_USER);
        request.then().statusCode(HttpStatus.SC_CREATED);

        return response;

    }
}
