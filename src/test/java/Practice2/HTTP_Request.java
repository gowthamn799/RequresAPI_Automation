package Practice2;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class HTTP_Request extends APIConstants{

    public void apiClientRequest(int status,String key,String value) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader("create").toJSONString()).when().post(PostEndPoint).then().spec(responseSpec(status, key, value)).log().all();
    }
    public void apiClientRequest(String key,String value,int status) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader("update").toJSONString()).when().put(PutEndPoint).then().spec(responseSpec(status, key, value)).log().all();
    }
    public void apiClientRequest(int status){
        Response response=given().spec(requestSpec()).when().get(GetEndPoint);
        String body=response.getBody().asPrettyString();
        Assert.assertEquals(response.getStatusCode(),status);
    }
    public void apiClientRequest(){
        given().spec(requestSpec()).when().delete(DeleteEndPoint).then().statusCode(204);
    }
}
