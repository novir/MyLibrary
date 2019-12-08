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
        Map<String, String> user = new HashMap<>();
        user.put("user", "create");
        user.put("user.login", "Frank");
        user.put("user.password", "lorem");
        user.put("user.email", "frank@example.com");
        Response response = POST("/users", user);
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
}