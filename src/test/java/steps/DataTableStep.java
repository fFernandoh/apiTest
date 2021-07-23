package steps;

import api.ReqresApi;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.util.List;

public class DataTableStep {

    private final ReqresApi reqresApi;
    Response response;

    public DataTableStep() {
        reqresApi = new ReqresApi();
    }

    @Dado("que passei os nomes em uma tabela")
    public void compareUserList(DataTable names) {
        response = reqresApi.getUserList(2);
        List<String> linhas = names.asList(String.class);
        for (int x = 0; x < linhas.size(); x++) {
            response.then().body("data["+x+"].first_name" , Matchers.is(linhas.get(x)));
        }
    }
}
