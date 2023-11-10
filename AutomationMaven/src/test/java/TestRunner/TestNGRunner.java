package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//dryRun - It will just compile and will check if all the steps are implemented
//dryRun = true
@CucumberOptions(features = "src/test/java/Cucumber",glue="stepDefinition",monochrome = true,
         plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"})
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
