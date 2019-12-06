package actions.users;

import actions.AbstractAction;
import dto.UserDto;
import services.users.ShowUserService;

import java.util.Optional;

public class ShowUserAction extends AbstractAction<UserDto> {

    public Optional<UserDto> execute(long id) {
        ShowUserService showUserService = new ShowUserService();
        return showUserService.execute(id);
    }

}
