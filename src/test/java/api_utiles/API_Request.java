package api_utiles;

import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;

import static api_utiles.API_Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class API_Request extends ReaderFiles{

    public static RequestSpecification reqSpec(){
        RequestSpecification request=given().baseUri(Base_URI).contentType(Content_Type).header(Header_Key,Header_Value).log().all();
        return request;
    }
    public static ResponseSpecification respSpec(int statusCode,String key,String value){
               return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .expectBody(key, equalTo(value))
                .build();
    }

    public void Http_clientRequest(String body,int status,String validatedKey,String validatedvalue) throws ParseException, IOException {
        given().spec(reqSpec()).body(jsonFileReader(body).toJSONString()).when().post(Post_Endpoint).then().spec(respSpec(status,validatedKey,validatedvalue));
    }
    public void Http_clientRequest(String body,int param ,int status,String validatedKey,String validatedvalue) throws ParseException, IOException {
        given().spec(reqSpec()).body(jsonFileReader(body).toJSONString()).when().put(Put_Endpoint+param).then().spec(respSpec(status,validatedKey,validatedvalue));
    }
//    public void Http_clientRequest(String body,int status,String validatedKey,String validatedvalue){
//        given().spec(reqSpec()).body(jsonFileReader(body).toJSONString()).when().patch(Patch_Endpoint).then().spec(respSpec(status,validatedKey,validatedvalue));
//    }
    public void Http_clientRequest(int status,int param){
        Response response=given().spec(reqSpec()).when().get(Get_Endpoint+param);
        String body=response.getBody().asPrettyString();
        System.out.println(body);
       given().then().statusCode(status);

    }
    public void Http_clientRequest(int status){
        given().spec(reqSpec()).when().delete(Delete_Endpoint).then().statusCode(status);
    }
}
