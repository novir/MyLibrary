import models.User;
import org.junit.*;
import java.util.*;
import play.test.*;

public class BasicTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
        Fixtures.loadModels("test-data/users.yml");
    }

    @Test
    public void createAndRetrieveUser() {

        // Retrieve the user with e-mail address bob@example.com
        User bob = User.find("byEmail", "bob@example.com").first();

        // Test
        assertNotNull(bob);
        assertEquals("Bob", bob.getLogin());
    }

}
