package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public WebDriver driverSetup() throws IOException {
        if (driver == null) {
            CommonFunctionsJava commonFunctionsJava=new CommonFunctionsJava();
            String PropBrowser= commonFunctionsJava.readProperties("Browser");
            if (PropBrowser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "C:\\Users\\ryadav\\Desktop\\Files\\Jars\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }

            //System.setProperty("webdriver.geko.driver","C:\\Users\\ryadav\\Desktop\\Files\\Jars\\geckodriver.exe");
            //FirefoxOptions cap=new FirefoxOptions();
            //cap.setCapability("marionette", true);
            //driver=new FirefoxDriver();
            else if (PropBrowser.equalsIgnoreCase("Chrome")) {
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
            } else if (PropBrowser.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/Resources/msedgedriver.exe");
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
