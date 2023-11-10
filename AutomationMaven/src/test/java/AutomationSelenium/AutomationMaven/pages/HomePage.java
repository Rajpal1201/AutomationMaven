package AutomationSelenium.AutomationMaven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class HomePage {
	public WebDriver driver;
  public HomePage(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver, this);
  }
  
  @FindBy(xpath="//a[@href='index.html']")
  public WebElement Home;
  
  @FindBy(id="login2")
  public WebElement Login;
  
  @FindBy(id="signin2")
  public WebElement SignUp;
  
  @FindBy(how = How.ID, using = "cartur")
  public WebElement Cart;
  
  @FindBy(id="nameofuser")
  public WebElement Welcome_User;
  
  public WebElement Product(String linkTxt) {
	  
	  return driver.findElement(By.linkText(linkTxt));
  }
  

}
