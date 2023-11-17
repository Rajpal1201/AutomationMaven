package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//dryRun - It will just compile and will check if all the steps are implemented
//dryRun = true
@CucumberOptions(features = "src/test/java/Cucumber",glue="stepDefinition",monochrome = true,
         plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json",
                 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
         "rerun:target/failed_scenarios.txt"})
public class TestNGRunner extends AbstractTestNGCucumberTests {
    // Run scenarios in parallel
//    @DataProvider(parallel = true)
//    @Override
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
