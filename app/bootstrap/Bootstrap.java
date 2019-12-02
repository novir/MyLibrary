package bootstrap;

import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        // Check if the users table is empty
        if (User.count() == 0) {
            // Below instruction causes hang up of Oracle driver, comment it when working on a real database
            // Fixtures.deleteDatabase();
            Fixtures.loadModels("test-data/users.yml");
            List<User> users = User.findAll();
            users.forEach((User user) -> {
                Tag tag = new Tag("BBB");
                tag.save();
                Book book = new Book(user, "AAA", LocalDate.now(), tag);
                book.save();
                user.setBooks(Collections.singletonList(book));
                user.save();
            });
        }
    }

}
