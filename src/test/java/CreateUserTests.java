import com.github.javafaker.Faker;
import models.CreateUserModel;
import org.junit.jupiter.api.Test;
import services.GoRestService;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateUserTests {
Faker faker = new Faker();
    @Test
    public void Users_CreateUsers_Success(){

        final CreateUserModel createUserModel = new CreateUserModel(faker.name().fullName(), "Male",
                faker.internet().emailAddress(), "Active");
        GoRestService.createUser(createUserModel)
                .then()
                .statusCode(SC_CREATED)
                .body("data.id", notNullValue())
                .body("data.name", equalTo(createUserModel.getName()));

        System.out.println(createUserModel.getName());
        System.out.println(createUserModel.getEmail());
    }
}
