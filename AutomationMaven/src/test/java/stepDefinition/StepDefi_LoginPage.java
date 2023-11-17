package stepDefinition;

import AutomationSelenium.AutomationMaven.pages.HomePage;
import AutomationSelenium.AutomationMaven.pages.LoginPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDefi_LoginPage {
    public LoginPage Ln;
    public HomePage homepage;
    public TestContextSetup testContextSetup;
    public StepDefi_LoginPage(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        homepage=testContextSetup.pageObjectManager.getHomePage();
        Ln = testContextSetup.pageObjectManager.getLoginPage();
    }

    @When("User log into the application")
    public void user_log_into_the_application() throws InterruptedException {

        homepage.Login.click();
        Thread.sleep(2000);
        Ln.Txt_Username.sendKeys("Rajpal");
        Ln.Txt_Password.sendKeys("Rajpal");
        Ln.Btn_LogIn.click();
        Thread.sleep(5000);
        Assert.assertEquals(homepage.Welcome_User.getText(), "Welcome Rajpal");

    }

    @Then("User log into the application with username {string} and password {string}")
    public void userLogIntoTheApplicationWithUsernameAndPassword(String username, String password) throws InterruptedException {
        homepage.Login.click();
        Thread.sleep(2000);
        Ln.Txt_Username.sendKeys(username);
        Ln.Txt_Password.sendKeys(password);
        Ln.Btn_LogIn.click();
        Thread.sleep(5000);
        Assert.assertEquals(homepage.Welcome_User.getText(), "Welcome "+username);
    }
}
