package stepDefinition;

import AutomationSelenium.AutomationMaven.pages.HomePage;
import AutomationSelenium.AutomationMaven.pages.LoginPage;
import AutomationSelenium.AutomationMaven.pages.ProductPage;
import AutomationSelenium.AutomationMaven.pages.SignUp;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

import java.io.IOException;

public class StepDefi_homePage {
    public LoginPage Ln;
    public SignUp signup;
    public HomePage homepage;
    public ProductPage productpage;
    public TestContextSetup testContextSetup;

    public StepDefi_homePage(TestContextSetup testContextSetup){
        this.testContextSetup= testContextSetup;
        Ln=testContextSetup.pageObjectManager.getLoginPage();
        signup=testContextSetup.pageObjectManager.getSignUp();
        homepage=testContextSetup.pageObjectManager.getHomePage();
        productpage=testContextSetup.pageObjectManager.getProductPage();
    }

    @Given("User is on home page of the site")
    public void user_is_on_home_page_of_the_site() throws IOException {
        testContextSetup.genericUtils.openUrl();
    }

    @And("User adds the product into the cart")
    public void user_adds_the_product_into_the_cart() throws InterruptedException {
        homepage.Product("Samsung galaxy s6").click();
        Assert.assertEquals(productpage.h_ProductName.getText(),"Samsung galaxy s6");
        productpage.Btn_AddtoCart.click();
        Thread.sleep(2000);
        Assert.assertEquals(testContextSetup.genericUtils.getAlertText(),"Product added.");
        testContextSetup.genericUtils.AcceptAlert();

    }

    @And("User adds the product {string} into the cart")
    public void userAddsTheProductIntoTheCart(String product) throws InterruptedException {
        homepage.Product(product).click();
        Assert.assertEquals(productpage.h_ProductName.getText(),product);
        productpage.Btn_AddtoCart.click();
        Thread.sleep(2000);
        Assert.assertEquals(testContextSetup.genericUtils.getAlertText(),"Product added.");
        testContextSetup.genericUtils.AcceptAlert();
    }

    @Given("This is the precondition for this feature")
    public void thisIsThePreconditionForThisFeature() {
        System.out.println("Precondition using background");
    }
}
