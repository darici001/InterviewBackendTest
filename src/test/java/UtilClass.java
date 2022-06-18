import io.restassured.http.ContentType;
import io.restassured.response.Response;
import services.BaseService;

import java.util.HashMap;
import java.util.Map;

public class UtilClass extends BaseService {
    public static Response getAllUsers(){
        return defaultRequestSpecification()
                .contentType(ContentType.JSON)
                .when()
                .get("/public/v1/users");
    }

    public static Response updateUser(){
        Map<String,String > reqBody = new HashMap<>();
        reqBody.put("name", "Fatih");
        reqBody.put("email","comdfa@dfa.co");
        return defaultRequestSpecification()
                .pathParam("id",3464)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .put("/public/v1/users/{id}");
    }
}
