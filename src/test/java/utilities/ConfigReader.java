package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

   public static Properties properties;

    static{
        String dosyaYolu ="configuration.properties";

        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            //fis dosyayolunu tanimladigimiz congiguration.properties dosyasini okudu
            properties= new Properties();
            properties.load(fis); //fisin okudugu bilgileri properties'e yukledi



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        /*
        test methodundan yolladigimiz string key degerini alip
        properties class'indan getProperty() method'unu kullanarak
        bu key'e ait value'u bize getirdi

         */

        return properties.getProperty(key);
    }
}
