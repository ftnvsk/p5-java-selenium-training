package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WindowPage extends BasePage {

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav-stacked>li>a")
    private List<WebElement> windowOptions;

    @FindBy(css = "#Tabbed button")
    private WebElement blankWindow;

    @FindBy(css = "#Separate button")
    private WebElement clickSepNewWindow;

    @FindBy(css = "#Multiple button")
    private WebElement clickMultipleWindow;

    public void  singleTab() {
        windowOptions.get(0).click();
        blankWindow.click();
        windowMethods.switchToSpecificWindow(1);
        windowMethods.closeWindow();
        windowMethods.switchToSpecificWindow(0);
    }

    public void  windowTab() {
        windowOptions.get(1).click();
        clickSepNewWindow.click();
        windowMethods.switchToSpecificWindow(1);
        windowMethods.closeWindow();
        windowMethods.switchToSpecificWindow(0);
    }

    public void  multipleTab() {
        windowOptions.get(2).click();
        clickMultipleWindow.click();
        windowMethods.switchToSpecificWindow(2);
        windowMethods.closeWindow();
        windowMethods.switchToSpecificWindow(1);
        windowMethods.closeWindow();
        windowMethods.switchToSpecificWindow(0);
    }

}
