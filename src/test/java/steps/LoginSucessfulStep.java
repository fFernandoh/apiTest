package steps;

import api.ReqresApi;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class LoginSucessfulStep {

    private final ReqresApi reqresApi;
    private Response response;

    public LoginSucessfulStep() {
        reqresApi = new ReqresApi();
    }

    @Dado("que passei o usuário e senha")
    public void fillUsernamePasswordField(DataTable dataTable) {
        List<Map<String , String>> users = dataTable.asMaps(String.class , String.class);

        for (int x = 0 ; x <= users.size() ; x++){
            response = reqresApi.loginSucessfull(dataTable.cell(x,0), dataTable.cell(x,1));
        }
    }

    @Então("devo logar no sistema e retornar um token")
    public void loginSucessful() {
        response.then().log().all();
    }
}
