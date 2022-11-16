package Tests;

import Pages.IndexPage;
import Pages.RegisterPage;
import SeleniumConfig.Hooks;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import java.util.HashMap;

public class RegisterTest extends Hooks {

    @Test
    public void SkipSigninTest() throws InterruptedException {

        HashMap<String, String> testData = propertiesFile.getAll();
        IndexPage indexPage = new IndexPage(cdriver);
        RegisterPage registerPage = new RegisterPage(cdriver);
        indexPage.clickSkipSignIn();
        Thread.sleep(4000);


        registerPage.uploadFileRegisterPage(testData);

        registerPage.fillRegisterPage(testData);

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) cdriver;
        js.executeScript("arguments[0].scrollIntoView();", cdriver.findElement(By.xpath("//button[@value='Refresh']")));
        Thread.sleep(4000);

        registerPage.selectLanguage(testData);

        registerPage.selectCountry(testData);

        registerPage.selectDateOfBirth(testData);
        Thread.sleep(10000);

    }

}