package Tests;


import Pages.IndexPage;
import Pages.LoginPage;
import SeleniumConfig.SeleniumConfig;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class LoginTest extends SeleniumConfig {

    WebElement signInBtn, emailField, pwdField, errSignin;
    String expectedErrSignin = "Invalid User Name or PassWord";
    String signInTitle = "SignIn";

    @Test
    public void LoginTest() throws InterruptedException {

        IndexPage indexPage = new IndexPage(cdriver);
        indexPage.clickSignIn();

        LoginPage loginPage = new LoginPage(cdriver);
        Thread.sleep(10000);
        loginPage.validateLoginInvalid("filipttt@gmail.com", "RandomPassword1234", expectedErrSignin);

    }

}
