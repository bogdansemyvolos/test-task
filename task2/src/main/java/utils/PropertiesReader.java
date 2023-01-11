package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static String getProperty(String fileName, String propertyName) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(getPropertiesFileLocation() + fileName)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(propertyName);
    }

    private static String getPropertiesFileLocation() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows") || os.contains("mac")) {
            return "src/main/resources/";
        } else {
            return "src\\main\\resources\\";
        }
    }
}
