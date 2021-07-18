package steps;

import api.ReqresApi;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

public class UpdateUserStep {

    private final ReqresApi reqresApi;
    private Response response;

    public UpdateUserStep() {
        reqresApi = new ReqresApi();
    }

    @Dado("que informei a pagina {int} onde deve ser atualizado")
    public void queInformeiAPaginaIdOndeDeveSerAtualizado(int n) {
        response = reqresApi.updateUser(n);
    }

    @Entao("deve me retornar uma msg com o nome, trabalho e a data da atualizacao")
    public void deveMeRetornarUmaMsgComONomeTrabalhoEADataDaAtualizacao() {
        response.then().log().all();
    }
}
