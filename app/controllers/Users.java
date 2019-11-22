package controllers;

import models.User;
import play.*;
import play.mvc.*;

import java.util.List;

public class Users extends CRUD {

    public static void index() {
        new User("Al", "secret", "al@example.com").save();
        new User("Bob", "secret", "bob@example.com").save();
        User alice = new User("Alice", "secret", "alice@example.com").save();
        alice.delete();
        List<User> users = User.find("").from(0).fetch(10);
        render(users);
    }

}