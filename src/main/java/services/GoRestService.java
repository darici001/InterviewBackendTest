package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.CreateUserModel;

import java.util.HashMap;
import java.util.Map;

public class GoRestService extends BaseService {

    public static Response createUser(final CreateUserModel createUserModel){
        return defaultRequestSpecification()
                .body(createUserModel)
                .when()
                .post("/public/v1/users");

    }
    public static Response getAllUsers(){
        return defaultRequestSpecification()
                .contentType(ContentType.JSON)
                .when()
                .get("/public/v1/users");
    }
    public static Response updateUser(){
        Map<String,String > reqBody = new HashMap<>();
        reqBody.put("name", "Ali");
        reqBody.put("email","comide@efa.co");
        return defaultRequestSpecification()
                .pathParam("id",3464)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .put("/public/v1/users/{id}");
    }
}
