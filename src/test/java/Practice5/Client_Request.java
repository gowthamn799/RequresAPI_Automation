package Practice5;

import Practice3.FileReader;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Client_Request extends API_Constants{
    public void Http_Request(int status,String key ,String value) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader("CreateData").toJSONString()).when().post(postEndpoint).then().spec(responseSpec(status,key,value)).log().all();
    }
    public void Http_Request(String key,String value,int status) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader("UpdateData").toJSONString()).when().put(putEndpoint).then().spec(responseSpec(status,key,value)).log().all();
    }
    public void HttpRequest(int status){
        Response response=given().spec(requestSpec()).when().get(getEndpoint);
        int actualStatus=response.getStatusCode();
        String body=response.getBody().asPrettyString();
        Assert.assertEquals(actualStatus,status);
    }
    public void Http_Request(){
        Response response=given().spec(requestSpec()).when().delete(deleteEndpoint);
        int actual=response.getStatusCode();
        Assert.assertEquals(actual,204);
    }

}
