package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav-stacked li a")
    private List<WebElement> alertsList;

    @FindBy(css ="#OKTab button")
    private WebElement alertBtn1;

    @FindBy(css ="CancelTab button")
    private WebElement alertBtn2;

    @FindBy(css ="Textbox button")
    private WebElement alertBtn3;

    public void acceptAlert() {
        alertsList.get(0).click();
        alertBtn1.click();
        alertMethods.acceptAlert();
    }

    public void dismissAlert() {
        alertsList.get(1).click();
        alertBtn2.click();
        alertMethods.dismissAlert();
    }

    public void fillAlert(String input) {
        alertsList.get(2).click();
        alertBtn3.click();
        alertMethods.fillAlert(input);
    }

}
