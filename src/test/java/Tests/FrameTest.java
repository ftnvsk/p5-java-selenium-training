package Tests;

import HelpMethods.ElementMethods;
import HelpMethods.FrameMethods;
import HelpMethods.PageMethods;
import SeleniumConfig.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FrameTest extends Hooks {

    @Test
    public void frameTest() throws InterruptedException {

        ElementMethods elementMethods = new ElementMethods(cdriver);
        PageMethods pageMethods = new PageMethods(cdriver);
        FrameMethods frameMethods = new FrameMethods(cdriver);

        WebElement skipSignIn = cdriver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignIn);

        WebElement switchToElement = cdriver.findElement(By.xpath("//a[text()='SwitchTo']"));
        elementMethods.moveToElement(switchToElement);

        WebElement framesElement = cdriver.findElement(By.xpath("//a[text()='Frames']"));
        framesElement.click();

        pageMethods.navigateToURL("https://demo.automationtesting.in/Frames.html");

        List<WebElement> buttonList = cdriver.findElements(By.cssSelector(".nav-tabs a"));
        buttonList.get(0).click();

        frameMethods.switchFrame("singleframe");
        WebElement iFrameInput = cdriver.findElement(By.cssSelector("input[type='text']"));
        iFrameInput.sendKeys("Booombaaa Filip");
        Thread.sleep(8000);

        frameMethods.switchToDefault();
//       cdriver.switchTo().defaultContent(); // switch back to the entire page
        buttonList.get(1).click();

        frameMethods.switchFrame(cdriver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        frameMethods.switchFrame(cdriver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
//        cdriver.switchTo().frame(cdriver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
//        cdriver.switchTo().frame(cdriver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        WebElement iFrameInput2 = cdriver.findElement(By.cssSelector("input[type='text']"));
        iFrameInput2.sendKeys("22 Booombaaa 222 Filip");
        Thread.sleep(8000);

    }

}
