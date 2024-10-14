package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "vedant.stepdefinitions",
monochrome = true, tags = "@verifyMessage" ,plugin = {"html:reports/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
}
