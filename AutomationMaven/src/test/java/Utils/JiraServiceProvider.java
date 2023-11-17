package Utils;

import net.rcarz.jiraclient.*;

public class JiraServiceProvider {
public JiraClient Jira;
public String project;
public String JiraUrl;

    public JiraServiceProvider(String JiraUrl, String username, String password, String project){
      this.JiraUrl=JiraUrl;
      //Create basic authentication object
        BasicCredentials creds= new BasicCredentials(username,password);
        //Initialize the jira client with url and credentials
        Jira=new JiraClient(JiraUrl,creds);
        this.project=project;
    }

    public void createJiraIssue(String issueType, String summary, String description, String reporterName)
    {
       try{
        //Avoid Creating Duplicate Issue
           Issue.SearchResult sr = Jira.searchIssues("summary ~ \""+summary+"\"");
           if (sr.total!=0){
               System.out.println("Same issue Already Exists on Jira");
               return;
           }

           //Create issue if not exists
           Issue.FluentCreate fluentCreate= Jira.createIssue(project,issueType);
           fluentCreate.field(Field.SUMMARY, summary);
           fluentCreate.field(Field.DESCRIPTION, description);
           Issue newIssue = fluentCreate.execute();
           System.out.println("**********************************");
           System.out.println("New issue created in Jira with ID: "+newIssue);
           System.out.println("New issue URL is: "+JiraUrl+"/browse/"+newIssue);
           System.out.println("**********************************");
       }
       catch (JiraException e) {
            e.printStackTrace();
       }

    }
}
