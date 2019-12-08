package actions.users;

import actions.AbstractListAction;
import dto.UserDto;
import services.users.ListUsersService;

import java.util.List;

public class ListUsersAction extends AbstractListAction<UserDto> {

    @Override
    protected List<UserDto> run() {
        ListUsersService listUsersService = new ListUsersService();
        return listUsersService.execute();
    }

}
