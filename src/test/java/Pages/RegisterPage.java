package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;
import java.util.List;

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

    @FindBy(xpath = "//div[@id='msdd']")
    private WebElement selectLanguageElement;

    @FindBy(css = ".ui-autocomplete>li>a")
    private List<WebElement> langList;

    @FindBy(xpath = "//span[@role='presentation']")
    private WebElement countryElement;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement countrySearchElement;

    @FindBy(id = "yearbox")
    private WebElement yearElement;

    @FindBy(xpath = "//select[@placeholder='Month']")
    private WebElement monthElement;

    @FindBy(id = "daybox")
    private WebElement dayElement;

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

    public void uploadFileRegisterPage(HashMap<String, String> testData) throws InterruptedException {
        Thread.sleep(2000);
        uploadElement.sendKeys(testData.get("fileLoc"));
    }
    public void fillRegisterPage(HashMap<String, String> testData) throws InterruptedException {
        Thread.sleep(2000);
        elementMethods.fillElement(firstNameElement, testData.get("firstName"));
        elementMethods.fillElement(lastNameElement, testData.get("lastName"));
        elementMethods.fillElement(emailElement, testData.get("email"));
        elementMethods.clickElement(genderElement);
        elementMethods.clickElement(hobbiesElement);
        elementMethods.selectDropDownText(skillsElement, testData.get("skills"));
    }

    public void selectLanguage(HashMap<String, String> testData) {
        elementMethods.clickElement(selectLanguageElement);
        for(Integer i = 0; i < langList.size(); i++) {
            if(langList.get(i).getText().equals(testData.get("language"))) {
                elementMethods.clickElement(langList.get(i));
                break;
            }
        }
    }

    public void selectCountry(HashMap<String, String> testData) {
        elementMethods.clickElement(countryElement);
        elementMethods.waitVisibleElement(countrySearchElement);
        elementMethods.fillElement(countrySearchElement, testData.get("country"));
        elementMethods.fillElementHitEnter(countrySearchElement);
    }

    public void selectDateOfBirth(HashMap<String, String> testData) {
        elementMethods.clickElement(yearElement);
        elementMethods.selectDropValue(yearElement, testData.get("year"));
        elementMethods.clickElement(monthElement);
        elementMethods.selectDropValue(monthElement, testData.get("month"));
        elementMethods.clickElement(dayElement);
        elementMethods.selectDropValue(dayElement, testData.get("day"));
    }

}
