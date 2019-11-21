package models;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import play.test.Fixtures;
import play.test.UnitTest;

public class UserTest extends UnitTest {

//    @Before
//    public void setup() {
//        Fixtures.deleteDatabase();
//    }

    @Test
    public void createAndRetrieveUser() {
        // Create a new user and save it
        String login = RandomStringUtils.randomAlphabetic(10);
        String email = login + "@example.com";
        new User(login,"secret", email).save();

        // Retrieve the user with e-mail address bob@gmail.com
        User bob = User.find("byEmail", email).first();

        // Test
        assertNotNull(bob);
        assertEquals(login, bob.login);

        bob.delete();
    }

}
