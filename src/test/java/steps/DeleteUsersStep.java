package steps;

import api.ReqresApi;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;

public class DeleteUsersStep {

    private final ReqresApi reqresApi;
    private Response response;

    public DeleteUsersStep() {
        reqresApi = new ReqresApi();
    }

    @Dado("que fiz um delete")
    public void queFizUmDelete(int id) {
        response = reqresApi.deleteUsers(id);
    }

    @Então("deve me retornar um status code ok")
    public void deveMeRetornarUmStatusCode() {
        response.then().log().all();
    }
}
