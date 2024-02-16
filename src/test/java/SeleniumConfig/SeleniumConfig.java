package SeleniumConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SeleniumConfig {

    public WebDriver cdriver;
 //   private String baseURL = "https://demo.automationtesting.in/Index.html";

    public void prepareDriver(String baseURL) {
        cdriver = new ChromeDriver();
        cdriver.get(baseURL);
        cdriver.manage().window().maximize();
        // WAIT implicit:
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
    }

    public void afterTest() {
        cdriver.quit();
    }

}
