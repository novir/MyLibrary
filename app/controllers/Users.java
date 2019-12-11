package controllers;

import actions.users.*;
import dto.UserDto;
import play.mvc.Controller;

public class Users extends Controller {

    private final ListUsersAction listUsersAction = new ListUsersAction();
    private final ShowUserAction showUserAction = new ShowUserAction();
    private final CreateUserAction createUserAction = new CreateUserAction();
    private final UpdateUserAction updateUserAction = new UpdateUserAction();
    private final RemoveUserAction removeUserAction = new RemoveUserAction();

    public void index() {
        renderJSON(listUsersAction.execute());
    }

    public void show(String id) {
        showUserAction.execute(id).ifPresent(Controller::renderJSON);
    }

    public void create(UserDto body) {
        createUserAction.execute(body).ifPresent(Controller::renderJSON);
    }

    public void update(String id, UserDto body) {
        updateUserAction.execute(id, body).ifPresent(Controller::renderJSON);
    }

    public void delete(String id) {
        removeUserAction.execute(id).ifPresent(Controller::renderJSON);
    }
}
