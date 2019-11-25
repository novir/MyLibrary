package bootstrap;

import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        // Check if the database is empty
        System.out.println("User.count() = " + User.count());
        if(User.count() == 0) {
            Fixtures.loadModels("data.yml");
        }
    }

}
