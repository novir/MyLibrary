package controllers;

import actions.users.GetUserAction;
import actions.users.ListUsersAction;
import dto.UserDto;
import play.mvc.Controller;

public class Users extends Controller {

    public static void index() {
        ListUsersAction listUsersAction = new ListUsersAction();
        renderJSON(listUsersAction.execute());
    }

    public static void show(long id) {
        GetUserAction getUserAction = new GetUserAction();
        getUserAction.execute(id).ifPresent(Controller::renderJSON);
    }

    public static void delete(long id) {
        System.out.println("Deleted " + id);
        renderJSON("{}");
    }

}
