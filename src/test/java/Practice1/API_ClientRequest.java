package Practice1;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class API_ClientRequest extends API_Constants{

    public void HttpRequest(int status,String key,String value) throws IOException, ParseException {
                 given().spec(requestSpec())
                .body(jsonReader("create_Data").toJSONString())
                .when().post(PostEndPoint)
                .then().spec(responseSpect(status, key, value))
                .log().all();
    }
    public void HttpRequest(String body,int status ,String key,String value) throws IOException, ParseException {
                 given().spec(requestSpec())
                .body(jsonReader(body).toJSONString())
                .when().put(PutEndPoint)
                .then().spec(responseSpect(status,key,value)).log().all();
    }
    public void HttpRequest(int status){
        Response response=given().spec(requestSpec()).when().get(GetEndPoint);
        String body=response.getBody().asPrettyString();
        int expectedStatus=response.getStatusCode();
        Assert.assertEquals(status,expectedStatus);
    }
    public void HttpRequest(){
        Response response=given().spec(requestSpec()).when().delete(DeleteEndPoint);
        int expectedStatus=response.getStatusCode();
        Assert.assertEquals(204,expectedStatus);
    }
}
