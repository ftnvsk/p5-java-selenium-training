package HelpMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementMethods {

    public WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    // WAIT
    // 2 feluri de wait: implicit si explicit
    public void clickElement(WebElement element) {
        waitVisibleElement(element);
        element.click();
    }

    public void waitVisibleElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
    }

    public void fillElementHitEnter(WebElement element) {
        waitVisibleElement(element);
        element.sendKeys(Keys.ENTER);
    }

    public void fillElement(WebElement element, String value) {
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void selectDropDownText(WebElement element, String text) {
        waitVisibleElement(element);
        Select elementSelect = new Select(element);
        elementSelect.selectByVisibleText(text);
    }

    public void selectDropValue(WebElement element, String value) {
        waitVisibleElement(element);
        Select elementSelect = new Select(element);
        elementSelect.selectByValue(value);
    }

    public void validateElementMessage(By by, String expMessage) {
        WebElement errElement =driver.findElement(by);
        String actualMessage = errElement.getText();
        Assert.assertEquals(actualMessage, expMessage);
    }

    public void validateElementMessage(WebElement element, String expMessage) {
        String actualMessage = element.getText();
        Assert.assertEquals(actualMessage, expMessage);
    }

    public void moveToElement(WebElement element) {
        waitVisibleElement(element);
        Actions elAction = new Actions(driver);
        elAction.moveToElement(element).perform();
    }

}
