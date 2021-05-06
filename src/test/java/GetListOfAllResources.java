import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.Map;


public class GetListOfAllResources {
    private int size = 100;
    private final String url = "https://jsonplaceholder.typicode.com/posts";


    @Test
    public void GetAllResources(){
        List<Map<String, Object>> products = RestAssured.get(url).as(new TypeRef<List<Map<String, Object>>>(){});
        Assert.assertTrue("Entities not " + size, products.size() == size);
    }
}
