import org.apache.commons.lang.RandomStringUtils;
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
        String login = RandomStringUtils.randomAlphabetic(5);
        String email = login + "@example.com";
        user.put("user", "create");
        user.put("user.login", login);
        user.put("user.password", "lorem");
        user.put("user.email", email);
        Response response = POST("/users", user);
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

    @Test
    public void testThatUserEditionWorks() {
        Map<String, String> user = new HashMap<>();
        user.put("user", "update");
        user.put("user.login", "Emma");
        user.put("user.password", "lorem");
        user.put("user.email", "emma@example.com");
        Response response = POST("/users/2", user);
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

//    @Test
//    public void testThatAuthorRemovalWorks() {
//        Response response = DELETE("/authors/10");
//        assertIsOk(response);
//        assertContentType("application/json", response);
//        assertCharset(play.Play.defaultWebEncoding, response);
//    }
//
//    @Test
//    public void testThatAuthorAdditionWorks() {
//        Map<String, String> user = new HashMap<>();
//        user.put("author", "create");
//        user.put("author.name", "Dirty Harry");
//        Response response = POST("/authors", user);
//        assertIsOk(response);
//        assertContentType("application/json", response);
//        assertCharset(play.Play.defaultWebEncoding, response);
//    }
//
//    @Test
//    public void testThatAuthorEditionWorks() {
//        Map<String, String> user = new HashMap<>();
//        user.put("author", "update");
//        user.put("author.name", "Dirty Frank");
//        Response response = POST("/authors/5", user);
//        assertIsOk(response);
//        assertContentType("application/json", response);
//        assertCharset(play.Play.defaultWebEncoding, response);
//    }
    
}