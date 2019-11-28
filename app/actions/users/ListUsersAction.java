package actions.users;

import actions.AbstractAction;
import models.User;
import services.users.ListUsersService;

import java.util.stream.Collectors;

public class ListUsersAction extends AbstractAction<User> {

    public String execute() {
        ListUsersService listUsersService = new ListUsersService();
        return listUsersService.execute()
                .stream()
                .map(this::getAsJson)
                .collect(Collectors.joining(",", "[", "]"));
    }

}
