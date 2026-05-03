package Practice2;

import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;
import static io.restassured.RestAssured.given;

public class API_Clients extends API_Constants {

    public void Http_Request(int status, long time, String key, String value) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader("createData").toJSONString()).when().post(PostEndPoint).then().spec(responseSpec(status, time, key, value)).log().all();

    }

    public void Http_Request(long time, int status, String key, String value) throws IOException, ParseException {
        given().spec(requestSpec()).body(jsonReader("updataDaata").toJSONString()).when().put(PutEndPoint).then().spec(responseSpec(status, time, key, value)).log().all();

    }

    public void Http_Request(int status, long time) {
        Response response = given().spec(requestSpec()).when().get(GetEndPoint);
        int actualStatus = response.getStatusCode();
        String body = response.getBody().asPrettyString();
        long actualTime = response.getTime();
        Assert.assertEquals(actualStatus, status);
        Assert.assertEquals(actualTime, time);
    }

    public void Http_Request(int status) {
        Response response = given().spec(requestSpec()).when().delete(DeleteEndPoint);
        int actualStatus = response.getStatusCode();
        Assert.assertEquals(actualStatus, status);
    }
}
