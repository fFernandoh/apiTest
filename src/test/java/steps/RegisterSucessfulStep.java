package steps;

import api.ReqresApi;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

public class RegisterSucessfulStep {

    private final ReqresApi reqresApi;
    private Response response;

    public RegisterSucessfulStep() {
        reqresApi = new ReqresApi();
    }

    @Dado("que passei email e a senha")
    public void quePasseiOsDados() {
        response = reqresApi.postRegisterSucessful();
    }

    @Entao("deve me retornar uma msg com sucesso")
    public void deveMeRetornarUmaMsgComSucesso() {
        response.then().log().all();
    }


}
