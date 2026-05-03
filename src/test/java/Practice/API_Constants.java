package Practice;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jdk.security.jarsigner.JarSigner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class API_Constants extends FileReader {

    public static String BaseURI=configReader("baseURI");
    public static String ContentType=configReader("contenttype");
    public static String HeaderKey=configReader("headerKey");
    public static String HeaderValue=configReader("headervalue");
    public static String PostEndpoint=configReader("post");
    public static String PutEndpoint=configReader("put");
    public static String PatchEndpoint=configReader("patch");
    public static String GetEndpoint=configReader("get");
    public static String DeleteEndpoint=configReader("delete");

    public static RequestSpecification requestSpec(){
        RequestSpecification request=given().
                                   baseUri(BaseURI).
                                   contentType(ContentType).
                                   header(HeaderKey,HeaderValue).
                                   log().all();
        return request;
    }
    public static ResponseSpecification responseSpec(int status,String key,String value){
        ResponseSpecification response= new ResponseSpecBuilder().
                expectStatusCode(status).
                expectBody(key,equalTo(value)).
                build();
        return response;
    }
}
