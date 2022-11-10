package SeleniumConfig;

import inputFiles.PropertiesFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SeleniumConfig {

    public PropertiesFile propertiesFile;

    @BeforeMethod
    public void prepareEnv() {
        prepareDriver();
        propertiesFile = new PropertiesFile();
    }

    @AfterMethod
    public void clearEnv() {
        afterTest();
    }

}
