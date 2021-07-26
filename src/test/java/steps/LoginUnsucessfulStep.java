package steps;

import api.ReqresApi;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

import java.util.List;
import java.util.Map;

public class LoginUnsucessfulStep {

    private final ReqresApi reqresApi;
    private Response response;

    public LoginUnsucessfulStep() {
        reqresApi = new ReqresApi();
    }

    @Dado("que informei o email")
    public void queInformeiOEmail(DataTable dataTable) {
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);

        for (int x = 1 ; x <= lista.size() ; x++){
            response = reqresApi.unsucessfulLogin(dataTable.cell(x , 0));
            response.then().statusCode(HttpStatus.SC_BAD_REQUEST);
        }
    }

    @Entao("deve me retornar uma mensagem de erro informando que falta a senha")
    public void deveMeRetornarUmaMensagemDeErroInformandoQueFaltaASenha() {
        response.then().log().all();
    }
}
