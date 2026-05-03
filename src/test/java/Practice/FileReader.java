package Practice;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

    public static String configReader(String key){
        Properties prop=new Properties();
        try{
         prop=new Properties();
        FileInputStream files=new FileInputStream("src/test/java/resources/config.properties");
        prop.load(files);
    }catch (Exception e){
            System.out.println("unable to read the File "+e.getMessage());
        }
        return prop.getProperty(key);
    }
    public static JSONObject jsonReader(String key) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONObject json= (JSONObject) parser.parse(new java.io.FileReader("src/test/resources/testData.json"));
        return (JSONObject) json.get(key);
    }
}
