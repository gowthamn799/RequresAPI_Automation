package api_utiles;

import groovy.json.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReaderFiles {

    public static String configFileReader(String key){
        Properties properties=new Properties();
        try {
            FileInputStream files=new FileInputStream("src/test/resources/Config.properties");
            properties.load(files);
        }catch (Exception e){
            System.out.println("Unable to load the ConfigFiles ");
        }
        return properties.getProperty(key);
    }
     public static JSONObject jsonFileReader(String key) throws IOException, ParseException {

         JSONParser parser=new JSONParser();
         JSONObject json= (JSONObject) parser.parse(new FileReader("src/test/resources/testData.json"));
         return (JSONObject) json.get(key);


     }
}
