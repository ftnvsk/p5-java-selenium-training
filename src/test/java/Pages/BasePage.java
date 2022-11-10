package Pages;

import HelpMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public WindowMethods windowMethods;
    public FrameMethods frameMethods;
    public AlertMethods alertMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        windowMethods = new WindowMethods(driver);
        frameMethods = new FrameMethods(driver);
        alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }



}
