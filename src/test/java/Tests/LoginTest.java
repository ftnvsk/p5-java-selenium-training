package Tests;


import Pages.IndexPage;
import Pages.LoginPage;
import SeleniumConfig.Hooks;
import org.testng.annotations.Test;

public class LoginTest extends Hooks {

    String expectedErrSignin = "Invalid User Name or PassWord";

    @Test
    public void LoginTest() throws InterruptedException {

        IndexPage indexPage = new IndexPage(cdriver);
        indexPage.clickSignIn();

        LoginPage loginPage = new LoginPage(cdriver);
        Thread.sleep(8000);
        loginPage.validateLoginInvalid(
                propertiesFile.getValue("email"),
                propertiesFile.getValue("password"),
                propertiesFile.getValue("loginErrMsg"));

    }

}
