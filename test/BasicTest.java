import models.User;
import org.junit.*;
import java.util.*;
import play.test.*;

public class BasicTest extends UnitTest {

    @Test
    public void createAndRetrieveUser() {
        // Create a new user and save it
        new User("Alice","secret", "alice@gmail.com").save();

        // Retrieve the user with e-mail address bob@gmail.com
        User bob = User.find("byEmail", "alice@gmail.com").first();

        // Test
        assertNotNull(bob);
        //assertEquals("Alice", bob.login);
    }

}
