package actions.users;

import actions.AbstractAction;
import dto.UserDto;
import services.users.RemoveUserService;

import java.util.Optional;

public class RemoveUserAction extends AbstractAction<UserDto> {

    public Optional<UserDto> execute(long id) {
        RemoveUserService removeUserService = new RemoveUserService();
        return removeUserService.execute(id);
    }

}
