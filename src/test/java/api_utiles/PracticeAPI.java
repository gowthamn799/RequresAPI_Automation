package api_utiles;

import groovy.json.JsonParser;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.groovy.json.internal.BaseJsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.IResultMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PracticeAPI {
    public static String configRead(String key){
        Properties prop= new Properties();
        try{
            FileInputStream files= new FileInputStream("src/test/resources/Confif.properties");
            prop.load(files);
        }catch (Exception e){
            System.out.println("Unable to Read from thr ConfigFile");
        }
        return prop.getProperty(key);
    }
    public static JSONObject jsonReader(String key) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONObject jsonObject= (JSONObject) parser.parse(new FileReader("Src/test/resouces/testdata.son"));
        return (JSONObject) jsonObject.get(key);
    }
    public static RequestSpecification requestSpec(){
        RequestSpecification reqSpec= given().contentType("sd").header("hh","jj").log().all();
        return  reqSpec;
    }
    public static ResponseSpecification responseSpec(int status ,String key, String value){
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .expectBody(key,equalTo(value))
                .build();
    }
    public void HTTP_Request(String key ,String value ,int status) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader("tyy").toJSONString()).when().post().then().spec(responseSpec(status,key,value));
    }
}
