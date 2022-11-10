package HelpMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertMethod {

    public WebDriver driver;
    public AlertMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void fillAlert(String alertMsg) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(alertMsg);
        alert.accept();
    }

}
