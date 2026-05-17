package Practice6;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class API_Constants extends FileReader{
    public static String BaseURI=configReader("baseURI");
    public static String ContentType=configReader("contentType");
    public static String HeaderKey=configReader("headerKey");
    public static String HeaderValue=configReader("headerValue");
    public static String postEndpoint=configReader("PostEndpoint");
    public static String putEndpoit=configReader("PutEndpoint");
    public static String patchEndpoint=configReader("PatchEndPoint");
    public static String getEndPoint=configReader("GetEndPoint");
    public static String deleteEndPoint=configReader("DeleteEndPoint");

    public static RequestSpecification resquestSpec(){
        RequestSpecification request=given().baseUri(BaseURI).contentType(ContentType).header(HeaderKey,HeaderValue).log().all();
        return  request;
    }
    public static ResponseSpecification responseSpec(String key,String value,int status){
        ResponseSpecification response=new ResponseSpecBuilder()
                .expectBody(key,equalTo(value)).expectStatusCode(status).build();
        return response;
    }
}
