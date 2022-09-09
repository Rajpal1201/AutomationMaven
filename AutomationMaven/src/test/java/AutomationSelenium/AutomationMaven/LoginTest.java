package AutomationSelenium.AutomationMaven;

import org.testng.annotations.Test;

import AutomationSelenium.AutomationMaven.pages.CartPage;
import AutomationSelenium.AutomationMaven.pages.HomePage;
import AutomationSelenium.AutomationMaven.pages.LoginPage;
import AutomationSelenium.AutomationMaven.pages.PlaceOrderPage;
import AutomationSelenium.AutomationMaven.pages.ProductPage;
import AutomationSelenium.AutomationMaven.pages.SignUp;
import Resources.DriverSetup;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class LoginTest{
	public WebDriver driver;
	public WebDriverWait wait;
	public LoginPage Ln;
	public SignUp signup;
	public HomePage homepage;
	public ProductPage productpage;
	public CartPage cartpage;
	public PlaceOrderPage placeorder;
	
	
  @Test(priority=2)
  public void Login() throws Exception {
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
	  signup.Txt_SignUsername.sendKeys("AXCV");
	  signup.Txt_SignPassword.sendKeys("AXCD");
	  signup.Btn_Sign_up.click();
	  Thread.sleep(2000);
	  Assert.assertEquals(driver.switchTo().alert().getText(), "Sign up successful.");
	  driver.switchTo().alert().accept();
	  
  }
  
  @Test(priority=3,enabled=true)
  public void AddtoCart() throws Exception {
	  
	 homepage.Product("Samsung galaxy s6").click();
	 Assert.assertEquals(productpage.h_ProductName.getText(),"Samsung galaxy s6");
	 productpage.Btn_AddtoCart.click();
	 Thread.sleep(2000);
	 Assert.assertEquals(driver.switchTo().alert().getText(),"Product added.");
	 driver.switchTo().alert().accept();
	 
	  
  }
  
  @Test(priority=4,enabled=true)
  public void PlaceOrder() throws Exception{
	  homepage.Cart.click();
	  wait.until(ExpectedConditions.visibilityOf(cartpage.Btn_PlaceOrder));
	  wait.until(ExpectedConditions.visibilityOf(cartpage.Lbl_Total));
	  int Price=cartpage.ProductPrice("Samsung galaxy s6");
	  System.out.println(Price);
	  cartpage.Btn_PlaceOrder.click();
	  wait.until(ExpectedConditions.visibilityOf(placeorder.lbl_Total));
	  
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
	  wait.until(ExpectedConditions.visibilityOf(placeorder.lbl_ThankYou));
	  placeorder.btn_OK.click();
	  wait.until(ExpectedConditions.elementToBeClickable(placeorder.btn_Close)).click();
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	driver=DriverSetup.driverSetup("Chrome");
	   Ln=new LoginPage(driver);
	   signup=new SignUp(driver);
	   homepage=new HomePage(driver);
	   productpage=new ProductPage(driver);
	   cartpage=new CartPage(driver);
	   placeorder=new PlaceOrderPage(driver);
	 driver.get("https://www.demoblaze.com/index.html");
	 driver.manage().window().maximize();
	 wait=new WebDriverWait(driver, 30);
	  
  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

}
