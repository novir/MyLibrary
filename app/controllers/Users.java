package controllers;

import actions.users.CreateUserAction;
import actions.users.ListUsersAction;
import actions.users.RemoveUserAction;
import actions.users.ShowUserAction;
import play.data.binding.Binder;
import play.data.validation.Required;
import play.mvc.Controller;

import java.util.Collections;

public class Users extends Controller {

    public static void index() {
        ListUsersAction listUsersAction = new ListUsersAction();
        renderJSON(listUsersAction.execute());
    }

    public static void show(long id) {
        ShowUserAction showUserAction = new ShowUserAction();
        showUserAction.execute(id).ifPresent(Controller::renderJSON);
    }

    public static void create(@Required String login, @Required String password, @Required String email) {
        CreateUserAction createUserAction = new CreateUserAction();
    }

    public static void update(long id) {

    }

    public static void delete(long id) {
        RemoveUserAction removeUserAction = new RemoveUserAction();
        removeUserAction.execute(id).ifPresent(Controller::renderJSON);
    }
}
