package Tests;

import SeleniumConfig.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends Hooks {

    @Test
    public void metodaTest() throws InterruptedException {
        WebElement skipSignIn = cdriver.findElement(By.id("btn2"));
        skipSignIn.click();

        WebElement switchToElement = cdriver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions actiuni = new Actions(cdriver);
        actiuni.moveToElement(switchToElement).perform();

        WebElement windowsElement = cdriver.findElement(By.xpath("//a[text()='Windows']"));
        actiuni.moveToElement(windowsElement).perform();

        cdriver.navigate().to("https://demo.automationtesting.in/Windows.html");
        List<WebElement> windowOptions = cdriver.findElements(By.cssSelector(".nav-stacked>li>a"));
        windowOptions.get(0).click();

        WebElement tabBtn = cdriver.findElement(By.cssSelector("#Tabbed button"));
        tabBtn.click();
        System.out.println(cdriver.getTitle());
        Thread.sleep(10000);

        // cdriver.getWindowHandles() - returns all tabs
        ArrayList<String> tabsList = new ArrayList<>(cdriver.getWindowHandles());
        cdriver.switchTo().window(tabsList.get(1));
        Thread.sleep(10000);
        System.out.println(cdriver.getTitle());

        // .close() - it closes the current tab
        cdriver.close();
        cdriver.switchTo().window(tabsList.get(0));
        windowOptions.get(1).click();

    }

}
