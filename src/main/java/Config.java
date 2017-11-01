import java.util.*;
import java.util.Properties;

public class Config {
    Properties configFile;
    public Config() {
        configFile = new Properties();
        try {
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        String value = this.configFile.getProperty(key);
        return value;
    }
}
