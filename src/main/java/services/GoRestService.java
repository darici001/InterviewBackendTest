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

}
