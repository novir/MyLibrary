package models;

import org.junit.Before;
import org.junit.Test;
import play.test.Fixtures;
import play.test.UnitTest;

import java.sql.Date;
import java.time.LocalDate;

public class BookTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
        Fixtures.loadModels("test-data/users.yml");
    }

    @Test
    public void createAndRetrieveBook() {
        User bob = User.find("byEmail", "bob@example.com").first();
        Book book = new Book(bob, "Bob's book", LocalDate.now());
        book.save();

        // Retrieve the user with e-mail address bob@gmail.com
        Book bobsBook = Book.find("byTitle", "Bob's book").first();

        // Test
        assertNotNull(bobsBook);
        //assertEquals("Bob's book", book.title);
    }

    @Test
    public void deleteRetrievedBook() {
        User bob = User.find("byEmail", "bob@example.com").first();
        Book book = new Book(bob, "Bob's book", LocalDate.now());
        book.save();
        long bobsBookCount = Book.count("byTitle", "Bob's book");
        assertEquals(1, bobsBookCount);

        book.delete();
        bobsBookCount = Book.count("byTitle", "Bob's book");
        assertEquals(0, bobsBookCount);

    }
}
