package AutomationSelenium.AutomationMaven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="loginusername")
	public WebElement Txt_Username;
	
	@FindBy(id="loginpassword")
	public WebElement Txt_Password;
	

	@FindBy(xpath="//button[@onclick='logIn()']")
	public WebElement Btn_LogIn;
	
	@FindBy(xpath="//button[@data-dismiss='modal']")
	public WebElement Btn_Close;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}
			

}
