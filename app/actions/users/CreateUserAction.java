package actions.users;

import actions.AbstractCrudAction;
import dto.UserDto;
import services.users.CreateUserService;

import java.util.Optional;

public class CreateUserAction extends AbstractCrudAction<UserDto> {

    @Override
    protected Optional<UserDto> run() {
        CreateUserService createUserService = new CreateUserService();
        return Optional.ofNullable(createUserService.execute(dto));
    }
}
