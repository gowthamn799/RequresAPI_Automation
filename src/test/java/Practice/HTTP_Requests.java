package Practice;

import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class HTTP_Requests extends API_Constants {

    public void httpRequest(String name,int status,String key,String value) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader(name)).when().post(PostEndpoint).then().spec(responseSpec(status,key,value)).log().all();
    }

    public void httpRequest(int status,String key,String value,String DataName) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader(DataName)).when().put(PutEndpoint).then().spec(responseSpec(status,key,value)).log().all();
    }
    public void httpRequest(int status,String key){
        Response response=given().spec(requestSpec()).when().get(GetEndpoint);
        Assert.assertEquals(status,response.getStatusCode());
        String body=response.getBody().asPrettyString();
        System.out.println(body);
        Assert.assertEquals(key,"dfghj");

    }
    public void httpRequest(int status){
        Response response=given().spec(requestSpec()).when().delete(DeleteEndpoint);
        Assert.assertEquals(status,response.getStatusCode());
        String body=response.getBody().asPrettyString();
    }
}
