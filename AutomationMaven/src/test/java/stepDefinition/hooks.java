package stepDefinition;

import Utils.JiraServiceProvider;
import Utils.TestContextSetup;
import io.cucumber.core.exception.ExceptionUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.reflect.FieldUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.Instant;

public class hooks {
    public TestContextSetup testContextSetup;
    public hooks(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    @After
    public void tearDown() throws IOException {
        testContextSetup.testBase.driverSetup().quit();
    }
    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        WebDriver driver= testContextSetup.testBase.driverSetup();
        TakeScreenShot(driver,scenario);
        if(scenario.isFailed()){
            TakeScreenShot(driver,scenario);
        }

    }

    public void TakeScreenShot(WebDriver driver,Scenario scenario) throws IOException {
        File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent=FileUtils.readFileToByteArray(sourcePath);
        scenario.attach(fileContent,"image/png","imageName"+TimeStamps());
    }
    public Timestamp TimeStamps(){
        return Timestamp.from(Instant.now());
    }
}
