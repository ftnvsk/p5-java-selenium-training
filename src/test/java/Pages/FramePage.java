package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav-tabs a")
    private List<WebElement> buttonsList;

    @FindBy(css = "input[type='text']")
    private WebElement inputElement;

    public void singleFrame(String frameMesg) {
        buttonsList.get(0).click();
        frameMethods.switchFrame("singleframe");
        inputElement.sendKeys(frameMesg);
        frameMethods.switchToDefault();
    }

    public void multipleFrame(String frameMesg) {
        buttonsList.get(1).click();
        frameMethods.switchFrame(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        frameMethods.switchFrame(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        inputElement.sendKeys(frameMesg);
    }

}
