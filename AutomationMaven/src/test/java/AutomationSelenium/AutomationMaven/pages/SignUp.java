package AutomationSelenium.AutomationMaven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
	
WebDriver driver;
	
	@FindBy(id="sign-username")
	public WebElement Txt_SignUsername;
	
	@FindBy(id="sign-password")
	public WebElement Txt_SignPassword;
	
	@FindBy(xpath="//button[@onclick='register()']")
	public WebElement Btn_Sign_up;
	
	
	@FindBy(xpath="//button[@class='btn btn-secondary']")
	public WebElement Btn_SignClose;
	
	
	
	public SignUp(WebDriver driver)
	{
		this.driver=driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}
			

}
