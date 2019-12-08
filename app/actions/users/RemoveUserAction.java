package actions.users;

import actions.AbstractCrudAction;
import dto.UserDto;
import services.users.RemoveUserService;

import java.util.Optional;

public class RemoveUserAction extends AbstractCrudAction<UserDto> {

    @Override
    protected Optional<UserDto> run() {
        RemoveUserService removeUserService = new RemoveUserService();
        return removeUserService.execute(id);
    }
}
