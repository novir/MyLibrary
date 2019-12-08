package actions.users;

import actions.AbstractCrudAction;
import dto.UserDto;
import services.users.ShowUserService;

import java.util.Optional;

public class ShowUserAction extends AbstractCrudAction<UserDto> {

    @Override
    protected Optional<UserDto> run() {
        ShowUserService showUserService = new ShowUserService();
        return showUserService.execute(id);
    }
}
