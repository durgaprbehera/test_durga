package ui.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "ui.tests.stepdefs",
                "ui.tests.hooks" // ✅ Include hooks package here
        },
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)
public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {
}
