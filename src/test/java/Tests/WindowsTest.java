package Tests;

import Pages.IndexPage;
import Pages.RegisterPage;
import Pages.WindowPage;
import SeleniumConfig.Hooks;
import org.testng.annotations.Test;

public class WindowsTest extends Hooks {

    @Test
    public void windowsTest() throws InterruptedException {

        IndexPage indexPage = new IndexPage(cdriver);
        indexPage.clickSkipSignIn();

        RegisterPage registerPage = new RegisterPage(cdriver);
        registerPage.goToWindow();

        WindowPage windowPage = new WindowPage(cdriver);
        windowPage.windowTab();
        Thread.sleep(5000);
        windowPage.singleTab();
        Thread.sleep(5000);
        windowPage.multipleTab();
        Thread.sleep(5000);

    }

}