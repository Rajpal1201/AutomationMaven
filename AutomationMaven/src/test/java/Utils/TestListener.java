package Utils;

import io.cucumber.core.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
      JiraServiceProvider jiraServiceProvider=new JiraServiceProvider("https://rajpal-yadav.atlassian.net/","yrajpal207@gmail.com","ATATT3xFfGF06yCB0zltVJE_CHSlIx45hbUgn5zEGOoz8dTGIWelu16H7UoK_HpEXw0BX6KOMuT4AdupMSxVsJ0Cr4Ub4lv5Ya93BeC8DhoD8n8j5cfAH_5i2UV9nC8udu_yPMD7Fd-kkfa8CC1xpH9af3sf3GLEx9Qx7z5Pfc7L7B4Q7KSj7xk=88D9B3C4","TES");
      String issueDescription = "Failure reason "+result.getThrowable().getMessage();
      issueDescription.concat(ExceptionUtils.printStackTrace(result.getThrowable()));
      String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()+" Failed in automation";
      jiraServiceProvider.createJiraIssue("Bug",issueSummary,issueDescription,"Rajpal Yadav");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

    }
}
