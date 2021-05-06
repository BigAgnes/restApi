import io.restassured.RestAssured;
import org.junit.Test;
import java.util.Collections;
import static org.hamcrest.Matchers.*;

public class FilteringByQueryParameters {
    private final String url = "https://jsonplaceholder.typicode.com/posts";
    private String userId = "userId";
    private String id = "id";
    private String title = "title";
    private String body = "body";

    @Test
    public void FilteringUserId(){
        RestAssured.when().get(url + "?userId=1")
                .then().assertThat().statusCode(200)
                .and().body("get(0)." + userId, equalTo(1))
                .and().body("get(0)." + id, equalTo(1))
                .and().body("get(0)." + title, equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .and().body("get(0)." + body, equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"))

                .and().body("get(1)." + userId, equalTo(1))
                .and().body("get(1)." + id, equalTo(2))
                .and().body("get(1)." + title, equalTo("qui est esse"))
                .and().body("get(1)." + body, equalTo("est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"))

                .and().body("get(2)." + userId, equalTo(1))
                .and().body("get(2)." + id, equalTo(3))
                .and().body("get(2)." + title, equalTo("ea molestias quasi exercitationem repellat qui ipsa sit aut"))
                .and().body("get(2)." + body, equalTo("et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"))

                .and().body("get(3)." + userId, equalTo(1))
                .and().body("get(3)." + id, equalTo(4))
                .and().body("get(3)." + title, equalTo("eum et est occaecati"))
                .and().body("get(3)." + body, equalTo("ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit"))

                .and().body("get(4)." + userId, equalTo(1))
                .and().body("get(4)." + id, equalTo(5))
                .and().body("get(4)." + title, equalTo("nesciunt quas odio"))
                .and().body("get(4)." + body, equalTo("repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque"))

                .and().body("get(5)." + userId, equalTo(1))
                .and().body("get(5)." + id, equalTo(6))
                .and().body("get(5)." + title, equalTo("dolorem eum magni eos aperiam quia"))
                .and().body("get(5)." + body, equalTo("ut aspernatur corporis harum nihil quis provident sequi\nmollitia nobis aliquid molestiae\nperspiciatis et ea nemo ab reprehenderit accusantium quas\nvoluptate dolores velit et doloremque molestiae"))

                .and().body("get(6)." + userId, equalTo(1))
                .and().body("get(6)." + id, equalTo(7))
                .and().body("get(6)." + title, equalTo("magnam facilis autem"))
                .and().body("get(6)." + body, equalTo("dolore placeat quibusdam ea quo vitae\nmagni quis enim qui quis quo nemo aut saepe\nquidem repellat excepturi ut quia\nsunt ut sequi eos ea sed quas"))

                .and().body("get(7)." + userId, equalTo(1))
                .and().body("get(7)." + id, equalTo(8))
                .and().body("get(7)." + title, equalTo("dolorem dolore est ipsam"))
                .and().body("get(7)." + body, equalTo("dignissimos aperiam dolorem qui eum\nfacilis quibusdam animi sint suscipit qui sint possimus cum\nquaerat magni maiores excepturi\nipsam ut commodi dolor voluptatum modi aut vitae"))

                .and().body("get(8)." + userId, equalTo(1))
                .and().body("get(8)." + id, equalTo(9))
                .and().body("get(8)." + title, equalTo("nesciunt iure omnis dolorem tempora et accusantium"))
                .and().body("get(8)." + body, equalTo("consectetur animi nesciunt iure dolore\nenim quia ad\nveniam autem ut quam aut nobis\net est aut quod aut provident voluptas autem voluptas"))

                .and().body("get(9)." + userId, equalTo(1))
                .and().body("get(9)." + id, equalTo(10))
                .and().body("get(9)." + title, equalTo("optio molestias id quia eum"))
                .and().body("get(9)." + body, equalTo("quo et expedita modi cum officia vel magni\ndoloribus qui repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error"));

        RestAssured.when().get(url + "?userId=a")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "?userId=A")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "?userId=1A")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "?userId=&")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "?userId=")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "/userId=1")
                .then().assertThat().statusCode(404)
                .and().body("", equalTo(Collections.emptyMap()));
    }

    @Test
    public void FilteringId(){
        RestAssured.when().get(url + "/1")
                .then().assertThat().statusCode(200)
                .and().body(userId, equalTo(1))
                .and().body(id, equalTo(1))
                .and().body(title, equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .and().body(body, equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));

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
                .and().body("get(0)." + userId, equalTo(1))
                .and().body("get(0)." + id, equalTo(1))
                .and().body("get(0)." + title, equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .and().body("get(0)." + body, equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));

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

    @Test
    public void FilteringTitle(){
        RestAssured.when().get(url + "?title")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "?title=not")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "/title")
                .then().assertThat().statusCode(404)
                .and().body("", equalTo(Collections.emptyMap()));

        RestAssured.when().get(url + "?title=magnam%20facilis%20autem")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));

        RestAssured.when().get(url + "?title=magnam")
                .then().assertThat().statusCode(200)
                .and().body("", equalTo(Collections.emptyList()));
    }
}
