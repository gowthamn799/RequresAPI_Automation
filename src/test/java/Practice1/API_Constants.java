package Practice1;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class API_Constants extends FileReader {

    public static String BaseURI=configReader("baseURI");
    public static String ContentType=configReader("contentType");
    public static String HeaderKey=configReader("headerKey");
    public static String HeaderValue=configReader("headerValue");
    public static String GetEndPoint=configReader("getEndpoint");
    public static String PostEndPoint=configReader("postEndpoint");
    public static String PutEndPoint=configReader("putEndpoint");
    public static String DeleteEndPoint=configReader("deleteEndpoint");

    public static RequestSpecification requestSpec(){
        RequestSpecification request= given().baseUri(BaseURI).
                                      contentType(ContentType).
                                      header(HeaderKey,HeaderValue).
                                       log().all();
        return request;
    }
    public static ResponseSpecification responseSpect(int status,String key,String value){
        ResponseSpecification response= new ResponseSpecBuilder()
                                       .expectStatusCode(status).expectBody(key,equalTo(value))
                                        .build();
        return response;
    }
}
