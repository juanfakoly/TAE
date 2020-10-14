package academyapi.servicepagone;

import academyapi.baseservice.BaseService;
import academyapi.pojos.JiraPost;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateIssue extends BaseService {

    private Response response;
    private int idIssue;

    public void jira() {
        response = requestPostMethodJira(fillPayload());
        setIdIssue(Integer.parseInt(response.jsonPath().get("id")));
    }

    private JiraPost fillPayload() {
        return new JiraPost("TAE", "REST ye merry gentlemen.", "Creating of an issue using project keys and issue type names using the REST API", "Bug");
    }

    public void fromMockAPI() {
        response = requestGetMethod("https://5f836d476b97440016f4e6d9.mockapi.io/users");
        boolean notEmpty = response.getBody().print().contains("id");
        if (notEmpty) {
            ArrayList<String> name = response.jsonPath().get("name");
            ArrayList<String> lastName = response.jsonPath().get("lastName");
            ArrayList<String> id = response.jsonPath().get("id");
            String description = String.format("User %s %s whit ID: %s found a defect related to bootcamp academy",
                    name.get(0), lastName.get(0), id.get(0));
            JiraPost post = new JiraPost("TAE", "Bug title - description", description, "Bug");
            response = requestPostMethodJira(post);
            setIdIssue(Integer.parseInt(response.jsonPath().get("id")));
        } else {
            Logger.getLogger("users").log(Level.WARNING, "there are not users registered");
        }
    }

    public int getIdIssue() {
        return idIssue;
    }

    public void setIdIssue(int idIssue) {
        this.idIssue = idIssue;
    }
}

