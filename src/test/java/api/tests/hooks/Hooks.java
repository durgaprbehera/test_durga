package api.tests.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println(">> Starting scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("<< Ending scenario: " + scenario.getName());
    }
}