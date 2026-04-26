package Practice4;


import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class API_Clients extends API_Constants{

    public void Http_Request(int status,String key,String value) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader("createData").toJSONString()).when().post(postEndPoint).then().spec(responsSpec(status,key,value)).log().all();
    }
    public void Http_Request(String key,String value,int status) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader("updated").toJSONString()).when().put(putEndPoint).then().spec(responsSpec(status,key,value)).log().all();
    }
    public void Http_Request(int status){
        Response response=given().spec(requestSpec()).when().get(getPostEndPoint);
        int actualstatus =response.getStatusCode();
        String body=response.getBody().asPrettyString();
        System.out.println(actualstatus);
        System.out.println(body);
        Assert.assertEquals(actualstatus,status);
    }
    public void Http_Request(){
        Response response=given().spec(requestSpec()).when().delete(deleteEndPoint);
        int actual=response.getStatusCode();
        Assert.assertEquals(actual,204);
    }

}
