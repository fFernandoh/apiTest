package steps;

import api.ReqresApi;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;


public class GetSingleUserStep {

    private final ReqresApi reqresApi;
    private Response response;

    public GetSingleUserStep() {
        reqresApi = new ReqresApi();
    }

    @Dado("que passei o id {word} do usuario")
    public void getUserData(String n) {
        response = reqresApi.getSingleUser(n);

    }

    @Entao("deve me retornar os dados do usuario informado")
    public void responseGetUserData() {
        response.then().log().all();

    }
}
