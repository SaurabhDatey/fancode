package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties = new Properties();

    static {
        try{
            FileInputStream input = new FileInputStream("src/main/resources/application.properties");
            properties.load(input);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to load application properties");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
