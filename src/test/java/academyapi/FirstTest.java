package academyapi;

import academyapi.servicepagone.CreateIssue;
import academyapi.servicepagone.PostUsers;
import academyapi.servicepagone.VerifyAPI;
import academyapi.servicepagone.VerifyIdIssue;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * First API test
 *
 * @author Brayhan.Criollo
 */
public class FirstTest {
    Response response;

   @Test(priority = 0)
    public void verifyAPI() {
        VerifyAPI verifyAPI = new VerifyAPI();
        verifyAPI.isEmpty();
    }

    @Test(priority = 1)
    public void postUsers() {
        PostUsers postUsers = new PostUsers();
        postUsers.postUsers();
    }

    @Test(priority = 2)
    public void postUserAlreadyExist() {
        PostUsers postUsers = new PostUsers();
        postUsers.postUsers();
    }

    @Test(priority = 3)
    public void postJiraIssues() {
        CreateIssue createIssue = new CreateIssue();
        createIssue.jira();
    }

    @Test(priority = 4)
    public void compareIssuesId() {
        CreateIssue createIssue = new CreateIssue();
        createIssue.jira();
        int idIssue1 = createIssue.getIdIssue();
        createIssue.jira();
        int idIssue2 = createIssue.getIdIssue();
        Assert.assertTrue(VerifyIdIssue.higherThan(idIssue1, idIssue2));

    }

    @Test(priority = 5)
    public void postJiraIssuesFromMockAPI() {
        CreateIssue createIssue = new CreateIssue();
        createIssue.fromMockAPI();
    }
}