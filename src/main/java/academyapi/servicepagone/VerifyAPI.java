package academyapi.servicepagone;

import academyapi.baseservice.BaseService;
import io.restassured.response.Response;
import java.util.List;

public class VerifyAPI extends BaseService {


    private static final String API_URL = "https://5f836d476b97440016f4e6d9.mockapi.io/users";

    public void isEmpty() {
        Response response = requestGetMethod(API_URL);
        boolean notEmpty = response.getBody().print().contains("id");
        if (notEmpty) {
            List<String> ids = response.jsonPath().getList("id");
            for (String id : ids) {
                requestDeleteMethod(API_URL, id);
            }
        }
    }
}

