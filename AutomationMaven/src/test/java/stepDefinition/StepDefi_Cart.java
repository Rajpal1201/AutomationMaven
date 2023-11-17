package stepDefinition;

import AutomationSelenium.AutomationMaven.pages.CartPage;
import AutomationSelenium.AutomationMaven.pages.HomePage;
import AutomationSelenium.AutomationMaven.pages.PlaceOrderPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class StepDefi_Cart {
    public HomePage homepage;
    public CartPage cartpage;
    public PlaceOrderPage placeorder;
    public TestContextSetup testContextSetup;

    public StepDefi_Cart(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        cartpage=testContextSetup.pageObjectManager.getCartPage();
        placeorder=testContextSetup.pageObjectManager.getPlaceOrderPage();
        homepage=testContextSetup.pageObjectManager.getHomePage();
    }
    @And("User checks out the order")
    public void user_checks_out_the_order() throws Exception {
        homepage.Cart.click();
        testContextSetup.genericUtils.waitUntilVisible(cartpage.Btn_PlaceOrder,30);
        testContextSetup.genericUtils.waitUntilVisible(cartpage.Lbl_Total,30);
        int Price=cartpage.ProductPrice("Samsung galaxy s6");
        System.out.println(Price);
        cartpage.Btn_PlaceOrder.click();
        testContextSetup.genericUtils.waitUntilVisible(placeorder.lbl_Total,30);

        String lbl_total=placeorder.lbl_Total.getText();
        String[] arr_lbltotal=lbl_total.split(" ",2);
        int placeorder_price = Integer.parseInt(arr_lbltotal[1]);
        System.out.println(placeorder_price);
        Assert.assertEquals(Price, placeorder_price);

    }
    @And("User fills the require details and places the order")
    public void user_fills_the_require_details_and_places_the_order() {
        // Write code here that turns the phrase above into concrete actions
        placeorder.txtbox_Name.sendKeys("Rajpal");
        placeorder.txtbox_Country.sendKeys("India");
        placeorder.txtbox_City.sendKeys("Guna");
        placeorder.txtbox_CreditCard.sendKeys("123456789");
        placeorder.txtbox_Month.sendKeys("11");
        placeorder.txtbox_Year.sendKeys("2024");
        placeorder.btn_Purchase.click();

    }

    @Then("Success message is displayed")
    public void success_message_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        testContextSetup.genericUtils.waitUntilVisible(placeorder.lbl_ThankYou,30);
        placeorder.btn_OK.click();
        testContextSetup.genericUtils.waitUntilVisible(placeorder.btn_Close,30).click();
        //driver.close();
    }

    @And("User checks out the order of product {string}")
    public void user_checks_out_the_order_of_product(String product) throws Exception {

        homepage.Cart.click();
        testContextSetup.genericUtils.waitUntilVisible(cartpage.Btn_PlaceOrder,30);
        testContextSetup.genericUtils.waitUntilVisible(cartpage.Lbl_Total,30);
        int Price=cartpage.ProductPrice(product);
        System.out.println(Price);
        cartpage.Btn_PlaceOrder.click();
        testContextSetup.genericUtils.waitUntilVisible(placeorder.lbl_Total,30);

        String lbl_total=placeorder.lbl_Total.getText();
        String[] arr_lbltotal=lbl_total.split(" ",2);
        int placeorder_price = Integer.parseInt(arr_lbltotal[1]);
        System.out.println(placeorder_price);
        Assert.assertEquals(Price, placeorder_price);
    }

    @And("User fills the given require details and places the order")
    public void user_fills_the_given_require_details_and_places_the_order(List<String> Data) {
        // Write code here that turns the phrase above into concrete actions
        placeorder.txtbox_Name.sendKeys(Data.get(0));
        placeorder.txtbox_Country.sendKeys(Data.get(1));
        placeorder.txtbox_City.sendKeys(Data.get(2));
        placeorder.txtbox_CreditCard.sendKeys(Data.get(3));
        placeorder.txtbox_Month.sendKeys(Data.get(4));
        placeorder.txtbox_Year.sendKeys(Data.get(5));
        placeorder.btn_Purchase.click();

    }
}
