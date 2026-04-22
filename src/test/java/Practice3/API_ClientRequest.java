package Practice3;

import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class API_ClientRequest extends API_Constants{

    public void HttpRequest(int status,String key,String value) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader("createData").toJSONString()).when().post(PostEndPoint).then().spec(responseSpec(status, key, value)).log().all();
    }
    public void HttpRequest(String key,String value,int status) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader("updatedData").toJSONString()).when().put(PutEndPoint).then().spec(responseSpec(status,key,value)).log().all();
    }
    public void HttpRequest(int status){
        Response response=given().spec(requestSpec()).when().get(GetEndPoint);
        int actual=response.getStatusCode();
        String body=response.getBody().asPrettyString();
        System.out.println(body);
        Assert.assertEquals(actual,status);
    }
    public void HttpRequest(){
        Response response=given().spec(requestSpec()).when().delete(DeleteEndPoint);
        int actual=response.getStatusCode();
        Assert.assertEquals(actual,204);
    }
}
