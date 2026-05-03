package Practice2;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReader {
<<<<<<< HEAD

    public static String configReader(String key){
        Properties prop=new Properties();
        try{
            FileInputStream files=new FileInputStream("src/test/resources/Config.properties");
            prop.load(files);
        }catch (Exception e){
            throw new RuntimeException("unable to read the cofigFile"+e.getMessage());
=======
    public static String configReader(String key){
        Properties prop=new Properties();
        try {
            FileInputStream files=new FileInputStream("src/test/resources/Config.properties");
            prop.load(files);

        }catch (Exception e){
            System.out.println("unable to read the config file");
>>>>>>> 2e65f497f42322fed14729e51f6a94b355e84dbe
        }
        return prop.getProperty(key);
    }
    public static JSONObject jsonReader(String key) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
<<<<<<< HEAD
        JSONObject json= (JSONObject) parser.parse(new java.io.FileReader("src/test/resources/testData/testSet1.json"));
        return (JSONObject) json.get(key);
=======
        JSONObject jsonObject= (JSONObject) parser.parse(new java.io.FileReader("src/test/resources/testData.json"));
        return (JSONObject) jsonObject.get(key);
>>>>>>> 2e65f497f42322fed14729e51f6a94b355e84dbe
    }
}
