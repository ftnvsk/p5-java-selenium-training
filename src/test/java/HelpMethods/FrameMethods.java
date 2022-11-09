package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {

    public WebDriver driver;
    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchFrame(String frame) {
        driver.switchTo().frame(frame);
    }

    public void switchFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

}
