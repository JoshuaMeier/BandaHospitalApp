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
            file = new File("D:\\Users\\jmbla.DESKTOP-L5RS36I\\Documents\\Software Engineering 2\\BandaHospitalApp\\config.cfg");
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
