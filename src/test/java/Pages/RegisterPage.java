package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='SwitchTo']")
    private WebElement switchToElement;

    @FindBy(xpath = "//a[text()='Alerts']")
    private WebElement alertElement;

    @FindBy(xpath = "//a[text()='Frames']")
    private WebElement frameElement;

    @FindBy(xpath = "//a[text()='Windows']")
    private WebElement windowElement;

    @FindBy(css = "input[ng-model='FirstName']")
    private WebElement firstNameElement;

    @FindBy(css = "input[ng-model='LastName']")
    private WebElement lastNameElement;

    @FindBy(css = "input[ng-model='EmailAdress']")
    private WebElement emailElement;

    @FindBy(css = "input[value='Male']")
    private WebElement genderElement;

    @FindBy(css = "input[value='Cricket']")
    private WebElement hobbiesElement;

    @FindBy(id = "Skills")
    private WebElement skillsElement;

    @FindBy(xpath = "//input[@id='imagesrc']")
    private WebElement uploadElement;

    public void goToAlert() {
        Actions action = new Actions(driver);
        action.moveToElement(switchToElement).perform();
        alertElement.click();
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
    }

    public void goToFrames() {
        elementMethods.moveToElement(switchToElement);
        elementMethods.clickElement(frameElement);
        pageMethods.navigateToURL("https://demo.automationtesting.in/Alerts.html");
    }

    public void goToWindow() {
        elementMethods.moveToElement(switchToElement);
        elementMethods.clickElement(windowElement);
        pageMethods.navigateToURL("https://demo.automationtesting.in/Windows.html");
    }

    public void uploadFileRegisterPage(String fileLoc) throws InterruptedException {
        Thread.sleep(5000);
        uploadElement.sendKeys(fileLoc);
    }
    public void fillRegisterPage(String fname, String lname, String email, String skillValue) throws InterruptedException {
        Thread.sleep(5000);
        elementMethods.fillElement(firstNameElement, fname);
        elementMethods.fillElement(lastNameElement, lname);
        elementMethods.fillElement(emailElement, email);
        elementMethods.clickElement(genderElement);
        elementMethods.clickElement(hobbiesElement);
        elementMethods.selectDropDownText(skillsElement, skillValue);
    }

}
