package SeleniumConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SeleniumConfig {

    public WebDriver cdriver;
    private String baseURL = "https://demo.automationtesting.in/Index.html";


    @BeforeMethod
    public void prepareDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        cdriver = new ChromeDriver();
        cdriver.manage().window().maximize();
        // WAIT implicit:
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        cdriver.get(baseURL);
    }

    @AfterMethod
    public void afterTest() {
        cdriver.quit();
    }

}
