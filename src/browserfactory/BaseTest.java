package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {  // browser opening setUp
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);

        driver.manage().window().maximize(); // Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // waits for the time given before throwing exception: here its 20 seconds.
    }

    //Browser closing code
    public void closeBrowser() {
        driver.quit(); // will close all browser windows and ends the webDriver session.
        // close only closes current/focused window on which selenium is running automated tests.
    }


}
