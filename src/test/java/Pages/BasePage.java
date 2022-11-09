package Pages;

import HelpMethods.ElementMethods;
import HelpMethods.FrameMethods;
import HelpMethods.PageMethods;
import HelpMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public WindowMethods windowMethods;
    public FrameMethods frameMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        windowMethods = new WindowMethods(driver);
        frameMethods = new FrameMethods(driver);
        PageFactory.initElements(driver, this);
    }



}
