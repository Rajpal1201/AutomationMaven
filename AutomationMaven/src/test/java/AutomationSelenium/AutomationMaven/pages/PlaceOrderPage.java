package AutomationSelenium.AutomationMaven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {
	public WebDriver driver;
	public PlaceOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	  
	  @FindBy(id="totalm")
	  public WebElement lbl_Total;
	  
	  @FindBy(id="name")
	  public WebElement txtbox_Name;
	  
	  @FindBy(id="country")
	  public WebElement txtbox_Country;
	  
	  @FindBy(how = How.ID, using = "city")
	  public WebElement txtbox_City;
	  
	  @FindBy(id="card")
	  public WebElement txtbox_CreditCard;
	  
	  @FindBy(id="month")
	  public WebElement txtbox_Month;
	  
	  @FindBy(id="year")
	  public WebElement txtbox_Year;
	  
	  @FindBy(xpath="//button[@onclick='purchaseOrder()']")
	  public WebElement btn_Purchase;
	  
	  @FindBy(xpath="//button[@onclick='purchaseOrder()']/preceding-sibling::button[text()='Close']")
	  public WebElement btn_Close;
	  
	  @FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	  public WebElement lbl_ThankYou;
	  
	  @FindBy(xpath="//button[text()='OK']")
	  public WebElement btn_OK;

	}
