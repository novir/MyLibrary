package actions.users;

import actions.AbstractAction;
import dto.UserDto;
import models.Book;
import models.User;
import services.users.GetUserService;
import services.users.ListUsersService;

import java.util.Optional;

public class GetUserAction extends AbstractAction<User> {

    public Optional<UserDto> execute(long id) {
        GetUserService getUserService = new GetUserService();
        return getUserService.execute(id);
    }

}
