package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class TestBase {
    public WebDriver driver;
    public WebDriver driverSetup() throws IOException {
        if (driver == null) {
            CommonFunctionsJava commonFunctionsJava=new CommonFunctionsJava();
            String PropBrowser= commonFunctionsJava.readProperties("Browser");
            String browser_Maven= System.getProperty("Browser");
            String browser= browser_Maven!=null ? browser_Maven : PropBrowser;
            if (browser.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

            //System.setProperty("webdriver.geko.driver","C:\\Users\\ryadav\\Desktop\\Files\\Jars\\geckodriver.exe");
            //FirefoxOptions cap=new FirefoxOptions();
            //cap.setCapability("marionette", true);
            //driver=new FirefoxDriver();
            else if (browser.equalsIgnoreCase("Chrome")) {
                //System.setProperty("webdriver.chrome.driver", "C:\\Users\\yrajp\\Work\\Jars\\chromedriver.exe");
                WebDriverManager.chromedriver().setup();

                //WebDriverManager.chromedriver().driverVersion("85.0.4183.38").setup();
                //WebDriverManager.chromedriver().browserVersion("83.0.4103").setup();
                /*
                 * WebDriverManager.chromedriver() .browserVersion("83.0.0") .arch64()
                 * .proxy("proxyhostname:80") .proxyUser("username") .proxyPass("password")
                 * .setup();
                 */

                driver = new ChromeDriver();
                //WebDriverManager.chromedriver().setup();
            } else if (browser.equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else {
                Assert.fail("Incorrect browser name");
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();

        }
        return driver;


    }



}
