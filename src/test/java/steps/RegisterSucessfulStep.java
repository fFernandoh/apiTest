package steps;


import api.ReqresApi;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class RegisterSucessfulStep {

    private final ReqresApi reqresApi;
    private Response response;

    public RegisterSucessfulStep() {
        reqresApi = new ReqresApi();
    }

    @Dado("que passei email e a senha")
    public void quePasseiOsDados(DataTable dataTable) {
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);

        for (int x = 1; x <= lista.size(); x++) {
            response = reqresApi.postRegisterSucessful(dataTable.cell(x, 0), dataTable.cell(x, 1));
        }
    }

    @Entao("deve me retornar uma msg com sucesso")
    public void deveMeRetornarUmaMsgComSucesso() {
        response.then().log().all();
    }


}
