import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;
import services.GoRestService;

import static org.apache.http.HttpStatus.SC_OK;


public class UpdateUserTest {
    @Test
    public void UserUpdate() {
       UtilClass.updateUser()
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .contentType(ContentType.JSON)
                .extract()

                .response().prettyPrint();
    }
}
