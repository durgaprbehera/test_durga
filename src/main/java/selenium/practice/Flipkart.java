package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Flipkart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            //WebDriverWait wait = new WebDriverWait(driver, WebDriver.Timeouts);
            driver.get("https://www.flipkart.com/");
            driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Motorola");
            List<WebElement> mobile = driver.findElements(By.xpath("//form/ul/li"));
            mobile.forEach(i -> System.out.println(i.getText()));
            mobile.get(3).click();
            //driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']//parent::div//preceding-sibling::button")).click();
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }


    }
}
