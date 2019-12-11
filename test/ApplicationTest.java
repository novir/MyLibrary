import commons.JsonConverter;
import dto.UserDto;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import play.mvc.Http.Response;
import play.test.FunctionalTest;

import java.util.HashMap;
import java.util.Map;

public class ApplicationTest extends FunctionalTest {

    private static JsonConverter<Map<String,String>> converter = new JsonConverter<>();

    @Before
    public void setUp() {

    }

    @Test
    public void testThatUserAdditionWorks() {
        Map<String, String> user = new HashMap<>();
        String login = RandomStringUtils.randomAlphabetic(5);
        String email = login + "@example.com";
        user.put("login", login);
        user.put("password", "lorem");
        user.put("email", email);
        String json = converter.serialize(user);
        Response response = POST("/users", "application/json", json);
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

    @Test
    public void testThatUserEditionWorks() {
        Map<String, String> user = new HashMap<>();
        user.put("login", "Emma");
        user.put("password", "lorem");
        user.put("email", "emma@example.com");
        String json = converter.serialize(user);
        Response response = POST("/users/2", "application/json", json);
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

    @Test
    public void testThatUserRemovalWorks() {
        Response response = DELETE("/users/3");
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

    @Test
    public void testThatAuthorAdditionWorks() {
        Map<String, String> author = new HashMap<>();
        author.put("name", "Dirty Harry");
        String json = converter.serialize(author);
        Response response = POST("/authors", "application/json", json);
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

    @Test
    public void testThatAuthorEditionWorks() {
        Map<String, String> author = new HashMap<>();
        author.put("name", "Dirty Frank");
        String json = converter.serialize(author);
        Response response = POST("/authors/5", "application/json", json);
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

    @Test
    public void testThatAuthorRemovalWorks() {
        Response response = DELETE("/authors/5");
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
}