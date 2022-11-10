package Tests;

import HelpMethods.ElementMethods;
import SeleniumConfig.Hooks;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest extends Hooks {

    WebElement skipSignBtn, firstName, lastName, email, gender, skillSelector, language, hobbies, country,
            countrySearch, yearSelector, uploadFile;

    @Test
    public void SkipSigninTest() throws InterruptedException {

        ElementMethods elementMethod = new ElementMethods(cdriver);

        skipSignBtn = cdriver.findElement(By.id("btn2"));
        elementMethod.clickElement(skipSignBtn);

        firstName = cdriver.findElement(By.cssSelector("input[ng-model='FirstName']"));
        elementMethod.fillElement(firstName, "Fiiillip");

        lastName = cdriver.findElement(By.cssSelector("input[ng-model='LastName']"));
        elementMethod.fillElement(lastName, "Taaantaaataaaaaa");

        email = cdriver.findElement(By.cssSelector("input[ng-model='EmailAdress']"));
        email.sendKeys("some.email@gmail.com");

        gender = cdriver.findElement(By.cssSelector("input[value='Male']"));
        gender.click();

        hobbies = cdriver.findElement(By.cssSelector("input[value='Cricket']"));
        hobbies.click();

        skillSelector = cdriver.findElement(By.id("Skills"));
        String skillsValue = "Java";
        elementMethod.selectDropDownText(skillSelector, skillsValue);

        uploadFile = cdriver.findElement(By.xpath("//input[@id='imagesrc']"));
        Thread.sleep(5000);
        uploadFile.sendKeys("C:\\Users\\ftanevski\\IdeaProjects\\p5-java-selenium-training\\src\\test\\resources\\clone4_87093.png");
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


        yearSelector = cdriver.findElement(By.id("yearbox"));
        String yearValue = "1998";
        elementMethod.selectDropValue(yearSelector, yearValue);

    }

}