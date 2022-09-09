package AutomationSelenium.AutomationMaven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;

	@FindBy(xpath="//h2[@class='name']")
	public WebElement h_ProductName;
	
	@FindBy(xpath="//a[@onclick='addToCart(1)']")
	public WebElement Btn_AddtoCart;
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}
			
}
