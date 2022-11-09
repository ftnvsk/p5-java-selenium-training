package HelpMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WindowMethods {

    public WebDriver driver;
    public WindowMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificWindow(Integer index) {
        ArrayList<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(index));
    }

    public void closeWindow() {
        driver.close();
    }

}
