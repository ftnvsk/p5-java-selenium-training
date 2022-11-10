package inputFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    public  Properties properties;
    public FileInputStream file;

    public PropertiesFile() {
        loadFile();
    }

    public void loadFile() {
        properties = new Properties();
        try {
            file = new FileInputStream("src/test/resources/inputData.properties");
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

}