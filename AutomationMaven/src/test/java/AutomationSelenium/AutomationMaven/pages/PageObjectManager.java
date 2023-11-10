package AutomationSelenium.AutomationMaven.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public WebDriver driver;
    public CartPage cartPage;
    public HomePage homePage;
    public LoginPage loginPage;
    public PlaceOrderPage placeOrderPage;
    public ProductPage productPage;
    public SignUp signUp;
    public PageObjectManager(WebDriver driver){
        this.driver=driver;

    }
    public CartPage getCartPage() {
        cartPage=new CartPage(driver);
        return cartPage;
    }
    public HomePage getHomePage() {
        homePage=new HomePage(driver);
        return homePage;
    }
    public LoginPage getLoginPage() {
        loginPage=new LoginPage(driver);
        return loginPage;
    }
    public PlaceOrderPage getPlaceOrderPage() {
        placeOrderPage=new PlaceOrderPage(driver);
        return placeOrderPage;
    }
    public ProductPage getProductPage() {
        productPage=new ProductPage(driver);
        return productPage;
    }
    public SignUp getSignUp() {
        signUp=new SignUp(driver);
        return signUp;
    }
}
