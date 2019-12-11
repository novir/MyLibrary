package controllers;

import actions.authors.*;
import dto.AuthorDto;
import play.mvc.Controller;

public class Authors extends Controller {

    private final ListAuthorsAction listAuthorsAction = new ListAuthorsAction();
    private final ShowAuthorAction showAuthorAction = new ShowAuthorAction();
    private final CreateAuthorAction createAuthorAction = new CreateAuthorAction();
    private final UpdateAuthorAction updateAuthorAction = new UpdateAuthorAction();
    private final RemoveAuthorAction removeAuthorAction = new RemoveAuthorAction();

    public void index() {
        renderJSON(listAuthorsAction.execute());
    }

    public void show(String id) {
        showAuthorAction.execute(id).ifPresent(Controller::renderJSON);
    }

    public void create(AuthorDto body) {
        createAuthorAction.execute(body).ifPresent(Controller::renderJSON);
    }

    public void update(String id, AuthorDto body) {
        updateAuthorAction.execute(id, body).ifPresent(Controller::renderJSON);
    }

    public void delete(String id) {
        removeAuthorAction.execute(id).ifPresent(Controller::renderJSON);
    }
}
