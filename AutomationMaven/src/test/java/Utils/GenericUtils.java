package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class GenericUtils {

    public WebDriver driver;
    public WebDriverWait wait;
    public GenericUtils(WebDriver driver){
        this.driver=driver;
    }
    public void openUrl() throws IOException {
        CommonFunctionsJava commonFunctionsJava=new CommonFunctionsJava();
        driver.get(commonFunctionsJava.readProperties("Url"));
        driver.manage().window().maximize();
    }
    public void AcceptAlert(){
        driver.switchTo().alert().accept();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
    public WebElement waitUntilVisible(WebElement element,int time){
        wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    public void driverQuit(){
        driver.quit();
    }

}
