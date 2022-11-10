package Tests;

import HelpMethods.AlertMethod;
import Pages.AlertsPage;
import Pages.IndexPage;
import Pages.RegisterPage;
import SeleniumConfig.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class AlertTest extends Hooks {

    @Test
    public void alertTest() throws InterruptedException {

        IndexPage indexPage = new IndexPage(cdriver);
        indexPage.clickSkipSignIn();
        RegisterPage registerPage = new RegisterPage(cdriver);
        registerPage.goToAlert();
        AlertsPage alertsPage = new AlertsPage(cdriver);
        alertsPage.acceptAlert();
        alertsPage.dismissAlert();
        alertsPage.fillAlert(propertiesFile.getValue("alertTestValue"));


    }
}
