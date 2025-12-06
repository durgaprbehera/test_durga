package ui.tests.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;

    @BeforeTest
    public void beforeTest(Scenario scenario) {
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println(">> Starting scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("<< Ending scenario: " + scenario.getName());
        driver.quit();
    }

    @AfterTest
    public void afterTest(Scenario scenario) {
        //driver.quit();
    }
}