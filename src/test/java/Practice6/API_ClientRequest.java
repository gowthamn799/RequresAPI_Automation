package Practice6;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class API_ClientRequest extends API_Constants{

    public static void Http_Request(String key,String value,int status) throws IOException, ParseException {
        given().spec(resquestSpec()).body(jsonReader("createData").toJSONString()).when().post(postEndpoint).then().spec(responseSpec(key, value, status)).log().all();
    }
    public static void Http_request(int status,String key,String value) throws IOException, ParseException {
        given().spec(resquestSpec()).body(jsonReader("UpdateDta").toJSONString()).when().put(putEndpoit).then().spec(responseSpec(key, value, status)).log().all();
    }
    public static void Http_resquest(int status){
        Response response=given().spec(resquestSpec()).when().get(getEndPoint);
        String body=response.getBody().asPrettyString();
        System.out.println(body);
        int actualStatus=response.getStatusCode();
        Assert.assertEquals(actualStatus,status);
    }
    public static void Http_request(){
        Response response=given().spec(resquestSpec()).when().delete(deleteEndPoint);
        int actalStatus=response.getStatusCode();
        Assert.assertEquals(actalStatus,204);
    }
}
