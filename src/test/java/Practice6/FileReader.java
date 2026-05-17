package Practice6;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

    public static String configReader(String key){
        Properties properties=new Properties();
        try{
            FileInputStream files=new FileInputStream("src/test/resources/Config.properties");
            properties.load(files);
        }catch (Exception e){
            throw new RuntimeException("Unable to read the config properties file"+e.getMessage());
        }
        return properties.getProperty(key);
    }
    public static JSONObject jsonReader(String key) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONObject json= (JSONObject) parser.parse(new java.io.FileReader("src/test/resources/testData/testsSet.json"));
        return (JSONObject) json.get(key);
    }
}
