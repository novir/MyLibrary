package controllers;

import actions.users.CreateUserAction;
import actions.users.ListUsersAction;
import actions.users.RemoveUserAction;
import actions.users.ShowUserAction;
import dto.UserDto;
import dto.binders.UserDtoBinder;
import play.data.binding.As;
import play.data.binding.Binder;
import play.data.validation.Required;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.Http;

import java.util.Collections;

public class Users extends Controller {

    public static void index() {
        ListUsersAction listUsersAction = new ListUsersAction();
        renderJSON(listUsersAction.execute());
    }


    public static void show(String id) {
        ShowUserAction showUserAction = new ShowUserAction();
        showUserAction.execute(id).ifPresent(Controller::renderJSON);
    }

    public static void create(UserDto user) {
        CreateUserAction createUserAction = new CreateUserAction();
        createUserAction.execute(user);
    }

    public static void update(String id) {

    }

    public static void delete(String id) {
        RemoveUserAction removeUserAction = new RemoveUserAction();
        removeUserAction.execute(id).ifPresent(Controller::renderJSON);
    }
}
