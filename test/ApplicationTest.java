import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;

public class ApplicationTest extends FunctionalTest {

    @Test
    public void testThatIndexPageWorks() {
        Response response = DELETE("/users/1");
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
}