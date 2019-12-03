package actions.users;

import actions.AbstractAction;
import models.Book;
import models.User;
import services.users.GetUserService;
import services.users.ListUsersService;

import java.util.Optional;

public class GetUserAction extends AbstractAction<User> {

    public User execute(long id) {
        GetUserService getUserService = new GetUserService();
        User user = getUserService.execute(id).orElse(new User("", "", ""));
        return user;
    }

}
