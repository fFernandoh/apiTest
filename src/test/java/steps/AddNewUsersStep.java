package steps;

import api.ReqresApi;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Map;

public class AddNewUsersStep {

    private final ReqresApi reqresApi;
    Response response;

    public AddNewUsersStep() {
        reqresApi = new ReqresApi();
    }

    @Dado("que eu passe alguns usuarios com nome e a funcao")
    public void addNewUsersInTable(DataTable newUsers){
        List<Map<String , String>> users = newUsers.asMaps(String.class , String.class);

        for(int x = 1 ; x <= users.size(); x++){
                response = reqresApi.addNewUser(newUsers.cell(x,0), newUsers.cell(x,1));
                response.getBody().prettyPrint();
                response.then().statusCode(HttpStatus.SC_CREATED);
        }
    }
}
