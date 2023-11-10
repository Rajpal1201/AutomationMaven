package Utils;

import AutomationSelenium.AutomationMaven.pages.PageObjectManager;
import org.openqa.selenium.WebDriver;
import stepDefinition.StepDefi_homePage;

import java.io.IOException;

public class TestContextSetup {
    public WebDriver driver;
    public StepDefi_homePage step_homepage;
    public TestBase testBase;
    public PageObjectManager pageObjectManager;
    public GenericUtils genericUtils;
    public TestContextSetup() throws IOException {
        testBase= new TestBase();
        pageObjectManager=new PageObjectManager(testBase.driverSetup());
        genericUtils=new GenericUtils(testBase.driverSetup());

    }
}
