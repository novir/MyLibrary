package actions.users;

import actions.AbstractAction;
import dto.UserDto;
import models.User;
import services.users.ListUsersService;

import java.util.List;
import java.util.stream.Collectors;

public class ListUsersAction extends AbstractAction<UserDto> {

    public List<UserDto> execute() {
        ListUsersService listUsersService = new ListUsersService();
        return listUsersService.execute();
    }

}
