package utils;

import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

public class Config {
    private static Properties properties;

    static {
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("falha para carregar config.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
