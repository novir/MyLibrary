package controllers;

import actions.users.ShowUserAction;
import actions.users.ListUsersAction;
import play.mvc.Controller;

public class Authors extends Controller {

    public static void index() {
        ListUsersAction listUsersAction = new ListUsersAction();
        renderJSON(listUsersAction.execute());
    }

    public static void show(long id) {
        ShowUserAction showUserAction = new ShowUserAction();
        //renderJSON(showUserAction.execute(id));
    }

    public static void delete(long id) {
        System.out.println("Deleted " + id);
        renderJSON("{}");
    }

}
