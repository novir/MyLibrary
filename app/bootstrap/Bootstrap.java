package bootstrap;

import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

import java.time.LocalDate;
import java.util.List;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        // Check if the database is empty
        if (User.count() == 0) {
            Fixtures.deleteDatabase();
            Fixtures.loadModels("test-data/users.yml");
            List<User> users = User.findAll();
            users.forEach((user) -> {
                user.setCreatedAt(LocalDate.now());
                user.save();
            });
        }
    }

}
