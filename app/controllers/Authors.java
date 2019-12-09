package controllers;

import actions.authors.*;
import dto.AuthorDto;
import play.mvc.Controller;

public class Authors extends Controller {

    public static void index() {
        ListAuthorsAction listAuthorsAction = new ListAuthorsAction();
        renderJSON(listAuthorsAction.execute());
    }

    public static void show(String id) {
        ShowAuthorAction showAuthorAction = new ShowAuthorAction();
        showAuthorAction.execute(id).ifPresent(Controller::renderJSON);
    }

    public static void create(AuthorDto author) {
        CreateAuthorAction createAuthorAction = new CreateAuthorAction();
        createAuthorAction.execute(author).ifPresent(Controller::renderJSON);
    }

    public static void update(String id, AuthorDto author) {
        UpdateAuthorAction updateAuthorAction = new UpdateAuthorAction();
        updateAuthorAction.execute(id, author).ifPresent(Controller::renderJSON);
    }

    public static void delete(String id) {
        RemoveAuthorAction removeAuthorAction = new RemoveAuthorAction();
        removeAuthorAction.execute(id).ifPresent(Controller::renderJSON);
    }

}
