package Tests;

import HelpMethods.ElementMethods;
import Pages.IndexPage;
import Pages.RegisterPage;
import SeleniumConfig.Hooks;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest extends Hooks {

    WebElement language, country, countrySearch;

    @Test
    public void SkipSigninTest() throws InterruptedException {

        IndexPage indexPage = new IndexPage(cdriver);
        indexPage.clickSkipSignIn();
        Thread.sleep(5000);

        RegisterPage registerPage = new RegisterPage(cdriver);

        registerPage.uploadFileRegisterPage(propertiesFile.getValue("fileLoc"));

        registerPage.fillRegisterPage(
                propertiesFile.getValue("firstName"),
                propertiesFile.getValue("lastName"),
                propertiesFile.getValue("email"),
                propertiesFile.getValue("skills"));

        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) cdriver;
        js.executeScript("arguments[0].scrollIntoView();", cdriver.findElement(By.xpath("//button[@value='Refresh']")));
        Thread.sleep(5000);

        language = cdriver.findElement(By.xpath("//div[@id='msdd']"));
        language.click();
        List<WebElement> langList = cdriver.findElements(By.cssSelector(".ui-autocomplete>li>a"));
        for(Integer i=0; i < langList.size(); i++) {
            if(langList.get(i).getText().equals("Croatian")) {
                langList.get(i).click();
                break;
            }
        }

        country = cdriver.findElement(By.xpath("//span[@role='presentation']"));
        Thread.sleep(3000);
        country.click();
        Thread.sleep(3000);
        countrySearch = cdriver.findElement(By.xpath("//input[@class='select2-search__field']"));
        countrySearch.sendKeys("Denmark");
        countrySearch.sendKeys(Keys.ENTER);

//        yearSelector = cdriver.findElement(By.id("yearbox"));
//        String yearValue = "1998";
//        elementMethod.selectDropValue(yearSelector, yearValue);

    }

}