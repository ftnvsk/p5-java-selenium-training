package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "btn1")
    public WebElement signInElement;

    public void clickSignIn() {
        elementMethods.clickElement(signInElement);
    }

}
