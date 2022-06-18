import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;
import services.GoRestService;

import static org.apache.http.HttpStatus.SC_OK;


public class UpdateUserTest {
    @Test
    public void UserUpdate() {
        // To update a data I need an id, to reach an id in database I created first getRequest
       UtilClass.updateUser()
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .contentType(ContentType.JSON)
                .extract()

                .response().prettyPrint();
    }
}
