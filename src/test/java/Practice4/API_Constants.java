package Practice4;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class API_Constants extends FileReader{

    public static String BaseUri=configReader("BaseUri");
    public static String ContentType=configReader("contentType");
    public static String Headerkey=configReader("headerKey");
    public static String HeaderValue=configReader("headerValue");
    public static String postEndPoint=configReader("postEndpoint");
    public static String putEndPoint=configReader("putEndPoint");
    public static String patchEndPoint=configReader("patchEndPoint");
    public static String getPostEndPoint=configReader("getEndpoint");
    public static String deleteEndPoint=configReader("deleteEndpoint");

    public static RequestSpecification requestSpec(){
        RequestSpecification request= given().baseUri(BaseUri).contentType(ContentType).header(Headerkey,HeaderValue).log().all();
        return request;
    }
    public static ResponseSpecification responsSpec(int status,String key,String value){
        ResponseSpecification response=new ResponseSpecBuilder().expectStatusCode(status).expectBody(key,equalTo(value)).build();
        return response;
    }
}
