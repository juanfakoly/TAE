package academyapi.pojos;

public class JiraPost {

    private String projectKey;
    private String summary;
    private String description;
    private String issueTypeName;

    public JiraPost(String projectKey, String summary, String description, String issueTypeName) {
        this.projectKey = projectKey;
        this.summary = summary;
        this.description = description;
        this.issueTypeName = issueTypeName;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssueTypeName() {
        return issueTypeName;
    }

    public void setIssueTypeName(String issueTypeName) {
        this.issueTypeName = issueTypeName;
    }
}
