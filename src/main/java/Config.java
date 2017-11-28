import java.util.*;
import java.io.*;
import java.util.Properties;

public class Config {
    Properties configFile;
    InputStream fin;
    File file;
    public Config() {
        configFile = new Properties();
        try {
            file = new File("../lib/config.cfg");
            fin = new FileInputStream(file);
            configFile.load(fin);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        String value = this.configFile.getProperty(key);
        return value;
    }
}
