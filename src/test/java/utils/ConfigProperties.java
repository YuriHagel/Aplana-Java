package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
  private final Properties properties = new Properties();
  private static ConfigProperties INSTANCE = null;

  private ConfigProperties(){
    try {
      properties.load(new FileInputStream
              (new File("src/main/resources/config.properties")));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static ConfigProperties getInstance() {
    if (INSTANCE == null){
      INSTANCE = new ConfigProperties();
    }
    return INSTANCE;
  }
  public Properties getProperties() {
    return properties;
  }

}
