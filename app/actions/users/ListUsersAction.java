package actions.users;

import models.User;
import services.users.ListUsersService;

import java.util.List;

public class ListUsersAction {

    public List<User> execute() {
        ListUsersService listUsersService = new ListUsersService();
        return listUsersService.execute();
    }

}
