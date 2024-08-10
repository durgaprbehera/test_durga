package playwright;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.instagram.com/");
            page.locator("//input[@name='username']").fill("durgaprabehera");
            page.locator("//input[@name='password']").fill("Welcome@1");
            page.locator("//button[@type='submit']/div").click();

            assertThat(page.getByText("Home").nth(1)).isVisible();
            assertThat(page.getByText("Search").nth(1)).isVisible();

            System.out.println(page.frames().toString());
            page.getByText("Search").nth(1).click();
            assertThat(page.getByText("shivanshbehera.2022").nth(1)).isVisible();
            page.getByText("shivanshbehera.2022").click();

            assertThat(page.locator("//h2[text()='shivanshbehera.2022']")).isVisible();

            System.out.println(page.title());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
    }
}
