package AutomationSelenium.AutomationMaven;

import AutomationSelenium.AutomationMaven.pages.*;
import Utils.TestContextSetup;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.io.IOException;


public class TestNGCases{
	public LoginPage Ln;
	public SignUp signup;
	public HomePage homepage;
	public ProductPage productpage;
	public CartPage cartpage;
	public PlaceOrderPage placeorder;
	public TestContextSetup testContextSetup;
//	public LoginTest(TestContextSetup testContextSetup){
//		this.testContextSetup=testContextSetup;
//	}
	@Test(priority=2)
  public void Login() throws Exception {
		homepage=testContextSetup.pageObjectManager.getHomePage();
		Ln = testContextSetup.pageObjectManager.getLoginPage();
	  homepage.Login.click();
	  Thread.sleep(2000);
	  Ln.Txt_Username.sendKeys("Rajpal");
	  Ln.Txt_Password.sendKeys("Rajpal");
	  Ln.Btn_LogIn.click();
	  Thread.sleep(5000);
	  Assert.assertEquals(homepage.Welcome_User.getText(), "Welcome Rajpal");
	  
  }
	@Test(priority=1,enabled=false)
  public void SignUp() throws Exception {
	  homepage.SignUp.click();
	  Thread.sleep(2000);
	  signup= testContextSetup.pageObjectManager.getSignUp();
	  signup.Txt_SignUsername.sendKeys("AXCV");
	  signup.Txt_SignPassword.sendKeys("AXCD");
	  signup.Btn_Sign_up.click();
	  Thread.sleep(2000);
	  Assert.assertEquals(testContextSetup.genericUtils.getAlertText(), "Sign up successful.");
	  testContextSetup.genericUtils.AcceptAlert();
	  
  }
	@Test(priority=3,enabled=true)
  public void AddtoCart() throws Exception {
	  productpage=testContextSetup.pageObjectManager.getProductPage();
	 homepage.Product("Samsung galaxy s6").click();
	 Assert.assertEquals(productpage.h_ProductName.getText(),"Samsung galaxy s6");
	 productpage.Btn_AddtoCart.click();
	 Thread.sleep(2000);
	 Assert.assertEquals(testContextSetup.genericUtils.getAlertText(),"Product added.");
	 testContextSetup.genericUtils.AcceptAlert();
  }
	@Test(priority=4,enabled=true)
  public void PlaceOrder() throws Exception{
		cartpage=testContextSetup.pageObjectManager.getCartPage();
		placeorder=testContextSetup.pageObjectManager.getPlaceOrderPage();
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
	  placeorder.txtbox_Name.sendKeys("Rajpal");
	  placeorder.txtbox_Country.sendKeys("India");
	  placeorder.txtbox_City.sendKeys("Guna");
	  placeorder.txtbox_CreditCard.sendKeys("123456789");
	  placeorder.txtbox_Month.sendKeys("11");
	  placeorder.txtbox_Year.sendKeys("2024");
	  placeorder.btn_Purchase.click();
	  testContextSetup.genericUtils.waitUntilVisible(placeorder.lbl_ThankYou,30);
	  placeorder.btn_OK.click();
	  testContextSetup.genericUtils.waitUntilVisible(placeorder.btn_Close,30).click();
	  
  }
	@BeforeTest
  public void LaunchApplication() throws IOException {
		testContextSetup=new TestContextSetup();
	 testContextSetup.genericUtils.openUrl();
	  }
	@AfterTest
  public void CloseBrowsers() {
	  testContextSetup.genericUtils.driverQuit();
  }

}
