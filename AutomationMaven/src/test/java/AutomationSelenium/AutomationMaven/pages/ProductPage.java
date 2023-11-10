package AutomationSelenium.AutomationMaven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2[@class='name']")
	public WebElement h_ProductName;
	
	@FindBy(xpath="//a[contains(@onclick,'addToCart')]")
	public WebElement Btn_AddtoCart;
	

			
}
