package playwright;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
    }
}
