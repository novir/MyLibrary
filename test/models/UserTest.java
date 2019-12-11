package models;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import play.test.Fixtures;
import play.test.UnitTest;

public class UserTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }

    @Test
    public void createAndRetrieveUser() {
        // Create new user and save it
        String login = RandomStringUtils.randomAlphabetic(10);
        String email = login + "@example.com";
        User user = new User(login,"secret", email);
        user.save();

        // Retrieve the user with e-mail address bob@gmail.com
        User bob = User.find("byEmail", email).first();

        // Test
        assertNotNull(bob);
        assertEquals(login, bob.getLogin());

        bob.delete();
    }

}
