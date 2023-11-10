package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonFunctionsJava {

    public String readProperties(String propKey) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(propKey);
    }
}
