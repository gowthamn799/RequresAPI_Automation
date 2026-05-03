package Practice2;

import Practice.FileReader;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIConstants extends FileReader {

    public static String BaseURI=configReader("baseURI");
    public static String Content_Type=configReader("contentType");
    public static String HeaderKey=configReader("header_Key");
    public static String Headervalue=configReader("headerValue");
    public static String PostEndPoint=configReader("post");
    public static String PutEndPoint=configReader("put");
    public static String GetEndPoint=configReader("get");
    public static String DeleteEndPoint=configReader("delete");


    public static RequestSpecification requestSpec(){
        RequestSpecification request=given().baseUri(BaseURI).contentType(Content_Type).header(HeaderKey,Headervalue).log().all();
        return request;
    }
    public static ResponseSpecification responseSpec(int status,String key,String value){
        ResponseSpecification response=new ResponseSpecBuilder().expectStatusCode(status).expectBody(key,equalTo(value)).build();
        return response;
    }
}
