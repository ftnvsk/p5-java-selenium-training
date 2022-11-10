package Tests;


import Pages.FramePage;
import Pages.IndexPage;
import Pages.RegisterPage;
import SeleniumConfig.Hooks;
import inputFiles.PropertiesFile;

import org.testng.annotations.Test;

import java.util.List;

public class FrameTest extends Hooks {

    @Test
    public void frameTest() throws InterruptedException {

        IndexPage indexPage = new IndexPage(cdriver);
        indexPage.clickSkipSignIn();

        RegisterPage registerPage = new RegisterPage(cdriver);
        registerPage.goToFrames();

        FramePage framePage = new FramePage(cdriver);
        framePage.singleFrame(propertiesFile.getValue("singleFrameTestValue"));
        Thread.sleep(4000);
        framePage.multipleFrame(propertiesFile.getValue("multipleFrameTestValue"));
        Thread.sleep(6000);

    }

}
