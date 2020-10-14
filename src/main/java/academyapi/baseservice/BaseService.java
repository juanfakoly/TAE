package academyapi.baseservice;

import academyapi.pojos.JiraPost;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Base Service TestNG + Rest Assured
 * Core API Methods
 *
 * @author Brayhan.Criollo
 */
public class BaseService {

    private Response response;

    public Response requestGetMethod(String url) {
        response = given().get(url);
        response.then().assertThat().statusCode(200);
        return response;
    }

    public Response requestPostMethod(String url, Map<String, Object> user) {
        response = given().contentType("application/json").body(user).when().post(url);
        response.then().assertThat().statusCode(201);
        return response;
    }

    public Response requestDeleteMethod(String url, String id) {
        response = given().baseUri(url).delete("/"+id);
        response.then().assertThat().statusCode(200);
        return response;
    }

    private ObjectNode payload(JiraPost post) {
        JsonNodeFactory jnf = JsonNodeFactory.instance;
        ObjectNode payload = jnf.objectNode();
        {
            ObjectNode fields = payload.putObject("fields");
            {
                ObjectNode project = fields.putObject("project");
                {
                    project.put("key", post.getProjectKey());
                }
                fields.put("summary", post.getSummary());
                fields.put("description", post.getDescription());
                ObjectNode issuetype = fields.putObject("issuetype");
                {
                    issuetype.put("name", post.getIssueTypeName());
                }
            }
        }
        return payload;
    }
    public Response requestPostMethodJira(JiraPost post) {
        response = RestAssured.given().header("Authorization", "Basic anVhbmZha29seUBnbWFpbC5jb206UWVUTXVKQ1V5WjdkakdkbGpOT1pCOEVF")
                .accept("application/json").contentType("application/json").body(payload(post))
                .when().post("https://juanfakoly.atlassian.net/rest/api/2/issue");
        response.getBody().prettyPrint();
        response.then().assertThat().statusCode(201);
        return response;
    }
}