package steps;

import api.ReqresApi;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

public class GetUserListStep {

    private final ReqresApi reqresApi;
    private Response response;

    public GetUserListStep() {
        reqresApi = new ReqresApi();
    }

    @Dado("que passei o id {int} da pagina de usuarios")
    public void quePasseiOIdIdDaPaginaDeUsuarios(int n) {
        response = reqresApi.getUserList(n);
    }

    @Entao("deve me retornar os dados dos usuarios da pagina")
    public void deveMeRetornarOsDadosDosUsuariosDaPagina() {
        response.then().log().all();
    }
}
