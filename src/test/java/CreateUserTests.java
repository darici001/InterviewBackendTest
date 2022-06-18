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
// For re-usability, I think,
// it could be better to take the name and unique email from the Java Faker class.

//        final CreateUserModel createUserModel = new CreateUserModel(faker.name().fullName(), "Male",
//                faker.internet().emailAddress(), "Active");

        final CreateUserModel createUserModel = new CreateUserModel("Gino Paloma", "Male",
                "qatest@test.com", "Active");
        GoRestService.createUser(createUserModel)
                .then()
                .statusCode(SC_CREATED)
                .body("data.id", notNullValue())
                .body("data.name", equalTo(createUserModel.getName()));

// Better to see here What is created on the console
//        System.out.println(createUserModel.getName());
//        System.out.println(createUserModel.getEmail());
    }
}
