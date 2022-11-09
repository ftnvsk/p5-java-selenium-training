package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageMethods {

    public WebDriver driver;

    public PageMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPageTitle(String value) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.titleIs(value));
    }

    public void validatePageTitle(String value) {
        waitPageTitle(value);
        Assert.assertTrue(driver.getTitle().equals(value));
    }

    public void navigateToURL(String valueURL) {
        driver.navigate().to(valueURL);
    }

}
