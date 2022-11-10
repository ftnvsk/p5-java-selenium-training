package Pages;

import org.checkerframework.common.reflection.qual.ForName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='SwitchTo']")
    private WebElement switchToElement;

    @FindBy(xpath = "//a[text()='Alerts']")
    private WebElement alertsElement;

    @FindBy(xpath = "//a[text()='Frames']")
    private WebElement framesElement;

    public void goToAlert() {
        Actions action = new Actions(driver);
        action.moveToElement(switchToElement).perform();
        alertsElement.click();
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
    }

    public void goToFrames() {
        elementMethods.moveToElement(switchToElement);
        elementMethods.clickElement(framesElement);
        pageMethods.navigateToURL("https://demo.automationtesting.in/Alerts.html");
    }

}
