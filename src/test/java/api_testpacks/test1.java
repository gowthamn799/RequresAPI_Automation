package api_testpacks;

import api_utiles.API_Request;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class test1 extends API_Request {
    @Test
    public void PostRequest() throws ParseException, IOException {
        Http_clientRequest("create_Data",201,"name","Gowtham");
    }
    @Test
    public void PutRequest() throws ParseException, IOException {
      Http_clientRequest("updated_Data",2,200,"job","Senior QA Engineer");
    }
    @Test
    public void GetRequest(){
     Http_clientRequest(200,2);
    }
    @Test
    public void DeleteRequest(){
     Http_clientRequest(204);
    }
}
