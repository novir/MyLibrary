package controllers;

import actions.users.*;
import dto.UserDto;
import play.mvc.Controller;

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
        createUserAction.execute(user).ifPresent(Controller::renderJSON);
    }

    public static void update(String id, UserDto user) {
        UpdateUserAction updateUserAction = new UpdateUserAction();
        updateUserAction.execute(id, user).ifPresent(Controller::renderJSON);
    }

    public static void delete(String id) {
        RemoveUserAction removeUserAction = new RemoveUserAction();
        removeUserAction.execute(id).ifPresent(Controller::renderJSON);
    }

}
