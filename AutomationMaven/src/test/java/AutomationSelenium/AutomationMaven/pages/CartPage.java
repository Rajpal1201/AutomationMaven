package AutomationSelenium.AutomationMaven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
	public WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	  
	  @FindBy(xpath="//button[text()='Place Order']")
	  public WebElement Btn_PlaceOrder;
	  
	  @FindBy(id="totalp")
	  public WebElement Lbl_Total;
	  
	  public int ProductPrice(String linkTxt) throws Exception {
		  int Price_Rs = 0;
		  int size=driver.findElements(By.xpath("//*[@id='tbodyid']/tr")).size();
		  for(int i=1;i<size+1;i++) {
		      if((driver.findElement(By.xpath("//*[@id='tbodyid']/tr["+i+"]/td[2]")).getText()).equalsIgnoreCase(linkTxt))
				 {
		    	  if(Price_Rs==0) {
			      String price=driver.findElement(By.xpath("//*[@id='tbodyid']/tr["+i+"]/td[3]")).getText();
			      Price_Rs=Integer.parseInt(price);
		    	  }
		    	  else {
		    		  driver.findElement(By.xpath("//*[@id='tbodyid']/tr["+i+"]/td[4]/a")).click();
		    		  size=size-1;
		    		  i=i-1;
			    	  Thread.sleep(3000);  
		    	  }
				 }
		      else {
		    	  driver.findElement(By.xpath("//*[@id='tbodyid']/tr["+i+"]/td[4]/a")).click();
		    	  size=size-1;
		    	  i=i-1;
		    	  Thread.sleep(3000);
		      }   
		  }
		  if(Price_Rs==0)
		  {
		  Assert.fail("Product not found in the Cart.");
		  }
		return Price_Rs;
	  }
	  

}
