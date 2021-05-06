import io.restassured.RestAssured;
import org.junit.Test;
import java.util.Collections;
import static org.hamcrest.Matchers.equalTo;

public class GetWithId {
    private final String url = "https://jsonplaceholder.typicode.com/posts";
    private String id = "id";

    @Test
    public void FilteringId(){
        RestAssured.when().get(url + "/1")
                .then().assertThat().statusCode(200)
                .and().body(id, equalTo(1));

        RestAssured.when().get(url + "/100")
                .then().assertThat().statusCode(200)
                .and().body(id, equalTo(100));

        RestAssured.when().get(url + "/101")
                .then().assertThat().statusCode(404)
                .and().body("", equalTo(Collections.emptyMap()));

        RestAssured.when().get(url + "/0")
                .then().assertThat().statusCode(404)
                .and().body("", equalTo(Collections.emptyMap()));

        RestAssured.when().get(url + "/a")
                .then().assertThat().statusCode(404)
                .and().body("", equalTo(Collections.emptyMap()));

        RestAssured.when().get(url + "/A")
                .then().assertThat().statusCode(404)
                .and().body("", equalTo(Collections.emptyMap()));

        RestAssured.when().get(url + "/0")
                .then().assertThat().statusCode(404)
                .and().body("", equalTo(Collections.emptyMap()));

        RestAssured.when().get(url + "?id=1")
                .then().assertThat().statusCode(200)
                .and().body("get(0)." + id, equalTo(1));

        RestAssured.when().get(url + "?id=100")
                .then().assertThat().statusCode(200)
                .and().body("get(0)." + id, equalTo(100));

        RestAssured.when().get(url + "?id=101")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "?id=0")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "?id=a")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "?id=A")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "?id=a")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "?id=")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));
    }
}
