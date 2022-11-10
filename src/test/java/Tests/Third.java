package Tests;

import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import HelpMethods.WindowMethods;
import SeleniumConfig.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Third extends Hooks {

    WebElement switchMenu, skipSignBtn, windowsMenu;

    @Test
    public void AlertTest() throws InterruptedException {

        ElementMethods elementsMethod = new ElementMethods(cdriver);
        PageMethods pagesMethod = new PageMethods(cdriver);
        WindowMethods windowMethod = new WindowMethods(cdriver);

        skipSignBtn = cdriver.findElement(By.id("btn2"));
        elementsMethod.clickElement(skipSignBtn);
        Thread.sleep(5000);

        switchMenu = cdriver.findElement(By.xpath("//a[text()='SwitchTo']"));
        elementsMethod.moveToElement(switchMenu);
//        hoverAction = new Actions(cdriver);
//        hoverAction.moveToElement(switchMenu).perform();

        windowsMenu = cdriver.findElement(By.xpath("//a[text()='Windows']"));
        elementsMethod.moveToElement(windowsMenu);

        pagesMethod.navigateToURL("https://demo.automationtesting.in/Windows.html");

        List<WebElement> windowOptions = cdriver.findElements(By.cssSelector(".nav-stacked>li>a"));
        windowOptions.get(0).click();

        WebElement blankWindow = cdriver.findElement(By.cssSelector("#Tabbed button"));
        blankWindow.click();

        windowMethod.switchToSpecificWindow(1);
        windowMethod.closeWindow();
        windowMethod.switchToSpecificWindow(0);

        windowOptions.get(1).click();

        WebElement clickSeparateWindow = cdriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a"));
        clickSeparateWindow.click();

        windowMethod.switchToSpecificWindow(1);
        windowMethod.closeWindow();
        windowMethod.switchToSpecificWindow(0);

        windowOptions.get(2).click();

        WebElement clickMultiWindow = cdriver.findElement(By.cssSelector("#Multiple button"));
        clickMultiWindow.click();

        windowMethod.switchToSpecificWindow(2);
        windowMethod.closeWindow();
        windowMethod.switchToSpecificWindow(1);
        windowMethod.closeWindow();
        windowMethod.switchToSpecificWindow(0);

    }

}
