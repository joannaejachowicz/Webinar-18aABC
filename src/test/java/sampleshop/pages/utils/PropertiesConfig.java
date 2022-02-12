package sampleshop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfig {
    public Properties properties = new Properties();
    private String configPath = System.getProperty("user.dir") + "/src/test/resources/configuration.properties";

    public void loadProperties() throws IOException {
        InputStream input = new FileInputStream(configPath);
        properties.load(input);
    }
}
