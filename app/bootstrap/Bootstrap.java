package bootstrap;

import models.Author;
import models.Book;
import models.Tag;
import models.User;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

import java.time.LocalDate;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        // Check if the users table is empty
        if (User.count() == 0) {
            // Below instruction causes hang up of Oracle driver, comment it when working on a real database
            if (Play.runingInTestMode()) {
                Fixtures.deleteDatabase();
            }
            Fixtures.loadModels("test-data/users.yml");
            User user = User.findById(1L);
            Author author = new Author("Margaret Mitchell");
            Tag war = new Tag("war");
            Tag drama = new Tag("drama");
            Tag history = new Tag("history");
            Book book1 = new Book(user, author, "Gone with the Wind", LocalDate.now(), drama, war, history);
            Book book2 = new Book(book1);
            user.addBook(book1);
            book2.setTitle("Scarlett");
            user.addBook(book2);
            user.save();
        }
    }

}
