package actions.users;

import actions.AbstractCrudAction;
import dto.UserDto;
import services.users.UpdateUserService;

import java.util.Optional;

public class UpdateUserAction extends AbstractCrudAction<UserDto> {

    @Override
    protected Optional<UserDto> run() {
        UpdateUserService updateUserService = new UpdateUserService();
        return updateUserService.execute(id, dto);
    }

}