package Tests;

import Pages.AlertsPage;
import Pages.IndexPage;
import Pages.RegisterPage;
import SeleniumConfig.Hooks;
import org.testng.annotations.Test;

public class AlertTest extends Hooks {

    @Test
    public void alertTest() throws InterruptedException {

        IndexPage indexPage = new IndexPage(cdriver);
        indexPage.clickSkipSignIn();
        Thread.sleep(4000);
        RegisterPage registerPage = new RegisterPage(cdriver);
        registerPage.goToAlert();
        Thread.sleep(4000);
        AlertsPage alertsPage = new AlertsPage(cdriver);
        Thread.sleep(4000);
        alertsPage.acceptAlert();
        alertsPage.dismissAlert();
        alertsPage.fillAlert(propertiesFile.getValue("alertTestValue"));


    }
}
