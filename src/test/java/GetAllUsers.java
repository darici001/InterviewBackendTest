import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import services.GoRestService;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.hasItem;

public class GetAllUsers {
    @Test
    public void Users_GetAllUsers(){
        //I created a UtilClass as your GoRestService
        // Because as testers we don't work on the main package and its classes.
        UtilClass.getAllUsers()
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .contentType(ContentType.JSON)
                .extract()

                .response().prettyPrint();


    }
}
