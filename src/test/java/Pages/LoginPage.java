package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[placeholder='E mail']")
    private WebElement emailElement;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement pwdElement;

    @FindBy(id = "enterbtn")
    private WebElement submitBtn;

    @FindBy(id = "errormsg")
    private WebElement errMsgElement;

    public void validateLoginInvalid(String email, String pwd, String expectedErrMsg) {
        elementMethods.fillElement(emailElement, email);
        elementMethods.fillElement(emailElement, pwd);
        elementMethods.clickElement(submitBtn);
        elementMethods.validateElementMessage(errMsgElement, expectedErrMsg);
    }

}
