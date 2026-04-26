package Practice4;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {
    public static String configReader(String Key){
        Properties prop=new Properties();
        try{
            FileInputStream files=new FileInputStream("src/test/resources/Config.Properties");
            prop.load(files);
        }catch (Exception e){
            throw new RuntimeException("Unable to Read the ConfigFile"+e.getMessage());
        }
        return prop.getProperty(Key);
    }
    public static JSONObject jsonReader(String key) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONObject json= (JSONObject) parser.parse(new java.io.FileReader("src/test/resources/testData.json"));
        return (JSONObject) json.get(key);
    }
}
