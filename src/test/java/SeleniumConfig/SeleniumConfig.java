package SeleniumConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SeleniumConfig {

    public WebDriver cdriver;
    private String baseURL = "https://demo.automationtesting.in/Index.html";

    public void prepareDriver() {
        cdriver = new ChromeDriver();
        cdriver.manage().window().maximize();
        // WAIT implicit:
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        cdriver.get(baseURL);
    }

    public void afterTest() {
        cdriver.quit();
    }

}
