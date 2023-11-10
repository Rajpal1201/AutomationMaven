package stepDefinition;

import AutomationSelenium.AutomationMaven.pages.*;
import Utils.TestContextSetup;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StepDefi_SignUp {
    public SignUp signup;
    public HomePage homepage;
    public TestContextSetup testContextSetup;

    public StepDefi_SignUp(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }
    @When("User sign up into application with username {string} and password {string}")
    public void userSignUpIntoApplicationWithUsernameAndPassword(String username, String password) throws InterruptedException {
        homepage=testContextSetup.pageObjectManager.getHomePage();
        signup=testContextSetup.pageObjectManager.getSignUp();
        homepage.SignUp.click();
        Thread.sleep(2000);
        signup.Txt_SignUsername.sendKeys(username);
        signup.Txt_SignPassword.sendKeys(password);
        signup.Btn_Sign_up.click();
        Thread.sleep(2000);
        Assert.assertEquals(testContextSetup.genericUtils.getAlertText(), "Sign up successful.");
        testContextSetup.genericUtils.AcceptAlert();
    }
}