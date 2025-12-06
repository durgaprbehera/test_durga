package ui.tests.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.tests.hooks.Hooks;

import java.time.Duration;

public class Login {

    WebDriver driver = Hooks.driver;

    @Given("I launch the MakeMyTrip application")
    public void i_launch_make_my_trip() {
        driver.get("https://www.makemytrip.com");
        driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
        // Handle any pop-ups or login overlays if needed
    }

    @And("I select {string} as the trip type")
    public void i_select_trip_type(String tripType) {
        if (tripType.equalsIgnoreCase("Round Trip")) {
            driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
        }
    }

    @And("I enter {string} as the source city")
    public void i_enter_source_city(String source) {
        WebElement fromInput = driver.findElement(By.id("fromCity"));
        fromInput.click();
        WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='From']"));
        inputField.sendKeys(source);
        driver.findElement(By.xpath("//p[contains(text(),'" + source + "')]")).click();
    }

    @And("I enter {string} as the destination city")
    public void i_enter_destination_city(String destination) {
        WebElement toInput = driver.findElement(By.id("toCity"));
        toInput.click();
        WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='To']"));
        inputField.sendKeys(destination);
        driver.findElement(By.xpath("//p[contains(text(),'" + destination + "')]")).click();
    }

    @And("I select departure date as {string}")
    public void i_select_departure_date(String depDate) {
        // Format: yyyy-MM-dd, parse and select accordingly
        // You may need to interact with calendar widget here
        // Placeholder for demo
    }

    @And("I select return date as {string}")
    public void i_select_return_date(String returnDate) {
        // Same as above; requires calendar interaction
    }

    @And("I click on the Search button")
    public void i_click_search_button() {
        driver.findElement(By.xpath("//a[text()='Search']")).click();
    }

    @Then("I should see a list of available flights")
    public void i_should_see_flight_results() {
        // Add wait or assertion to verify flight list appears
        WebElement flightList = driver.findElement(By.xpath("//div[contains(@class,'flight-card')]"));
        assert flightList.isDisplayed();
    }

    @And("the flight results should include flights from {string} to {string}")
    public void flight_results_should_include_route(String from, String to) {
        String pageText = driver.getPageSource();
        assert pageText.contains(from) && pageText.contains(to);
    }
}