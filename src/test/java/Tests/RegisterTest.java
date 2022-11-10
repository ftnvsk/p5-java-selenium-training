package Tests;

import HelpMethods.ElementMethods;
import Pages.IndexPage;
import Pages.RegisterPage;
import SeleniumConfig.Hooks;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class RegisterTest extends Hooks {

    WebElement country, countrySearch;

    @Test
    public void SkipSigninTest() throws InterruptedException {

        IndexPage indexPage = new IndexPage(cdriver);
        ElementMethods elementMethods = new ElementMethods(cdriver);
        indexPage.clickSkipSignIn();
        Thread.sleep(4000);

        RegisterPage registerPage = new RegisterPage(cdriver);

        registerPage.uploadFileRegisterPage(propertiesFile.getValue("fileLoc"));

        registerPage.fillRegisterPage(
                propertiesFile.getValue("firstName"),
                propertiesFile.getValue("lastName"),
                propertiesFile.getValue("email"),
                propertiesFile.getValue("skills"));

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) cdriver;
        js.executeScript("arguments[0].scrollIntoView();", cdriver.findElement(By.xpath("//button[@value='Refresh']")));
        Thread.sleep(4000);

        registerPage.selectLanguage(propertiesFile.getValue("language"));

        registerPage.selectCountry(propertiesFile.getValue("country"));

        registerPage.selectDateOfBirth(propertiesFile.getValue("year"),
                propertiesFile.getValue("month"),
                propertiesFile.getValue("day"));
        Thread.sleep(10000);

    }

}