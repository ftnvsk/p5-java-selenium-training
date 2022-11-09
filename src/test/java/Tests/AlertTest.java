package Tests;

import HelpMethods.AlertMethod;
import SeleniumConfig.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class AlertTest extends SeleniumConfig {

    @Test
    public void alertTest() throws InterruptedException {

        AlertMethod alertMethod = new AlertMethod(cdriver);
        WebElement skipSignIn = cdriver.findElement(By.id("btn2"));
        skipSignIn.click();

        WebElement switchToElement = cdriver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions action = new Actions(cdriver);
        action.moveToElement(switchToElement).perform();

        WebElement alertElement = cdriver.findElement(By.xpath("//a[text()='Alerts']"));
        alertElement.click();

        cdriver.navigate().to("https://demo.automationtesting.in/Alerts.html");
        Thread.sleep(10000);
        List<WebElement> alertList = cdriver.findElements(By.cssSelector(".nav-stacked li a"));

        alertList.get(0).click();
        WebElement alertBtn0 = cdriver.findElement(By.cssSelector("#OKTab button"));
        alertBtn0.click();
        alertMethod.AcceptAlert();

        alertList.get(1).click();
        WebElement alertBtn1 = cdriver.findElement(By.cssSelector("#CancelTab button"));
        alertBtn1.click();
        alertMethod.DismissAlert();

        alertList.get(2).click();
        WebElement alertBtn2 = cdriver.findElement(By.cssSelector("#Textbox button"));
        alertBtn2.click();
        alertMethod.FillAlert("This is a random value entered by Filip Tanevski");
    }
}
