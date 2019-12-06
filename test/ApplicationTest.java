import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;

import java.util.HashMap;
import java.util.Map;

public class ApplicationTest extends FunctionalTest {

    @Test
    public void testThatUserRemovalWorks() {
        Response response = DELETE("/users/3");
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

    @Test
    public void testThatUserAdditionWorks() {
        Map<String, String> params = new HashMap<>();
        params.put("login", "Frank");
        params.put("password", "lorem");
        params.put("email", "frank@example.com");
        Response response = POST("/users", params);
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
}