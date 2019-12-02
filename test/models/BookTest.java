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
        //Fixtures.deleteDatabase();
    }

    @Test
    public void createAndRetrieveBook() {
        User bob = User.find("byEmail", "bob@gmail.com").first();
        new Book(bob, "Bob's book", LocalDate.now()).save();

        // Retrieve the user with e-mail address bob@gmail.com
        Book book = Book.find("byTitle", "Bob's book").first();

        // Test
        assertNotNull(book);
        //assertEquals("Bob's book", book.title);
    }

    @Test
    public void deleteRetrievedBook() {
        User bob = User.find("byEmail", "bob@gmail.com").first();
        new Book(bob, "Bob's book", LocalDate.now()).save();

        Book book = Book.find("byTitle", "Bob's book").first();
        book.delete();

        long bobsBookCount = Book.count("byTitle", "Bob's book");
        assertNotEquals(0, bobsBookCount);
    }
}
