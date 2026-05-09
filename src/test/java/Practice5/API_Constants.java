package Practice5;

import Practice3.FileReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class API_Constants extends FileReader {
    public static String BaseUri=configReader("baseUri");
    public static String Content_Type=configReader("contentType");
    public static String Header_key=configReader("headerkey");
    public static String Header_value=configReader("headervalue");
    public static String postEndpoint=configReader("postEndPoint");
    public static String putEndpoint=configReader("putEndPoint");
    public static String patchEndpoint=configReader("patchEndPoint");
    public static String getEndpoint=configReader("getEndPoint");
    public static String deleteEndpoint=configReader("deleteEndPoint");

    public static RequestSpecification requestSpec(){
        RequestSpecification request= given().baseUri(BaseUri).contentType(Content_Type).header(Header_key,Header_value).log().all();
        return request;
    }
    public static ResponseSpecification responseSpec(int status,String key,String value ){
        ResponseSpecification response=new ResponseSpecBuilder()
                .expectStatusCode(status).
                expectBody(key,equalTo(value))
                .build();
        return response;
    }
}
