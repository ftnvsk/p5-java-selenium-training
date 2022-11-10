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
    private List<WebElement> windowOption;

    @FindBy(css = "#Tabbed button")
    private WebElement blankWindow;

    @FindBy(css = "#Separate button")
    private WebElement clickSepNewWindow;

    @FindBy(css = "#Multiple button")
    private WebElement clickMultipleWindow;

    public void  singleTab() {
        windowOption.get(0).click();
    }

}
