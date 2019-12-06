package actions.users;

import actions.AbstractAction;
import dto.UserDto;
import services.users.CreateUserService;

import java.util.Map;

public class CreateUserAction extends AbstractAction<UserDto> {

    public UserDto execute(Map<String, String> parameters) {
        CreateUserService createUserService = new CreateUserService();
        UserDto user = new UserDto.UserDtoBuilder(parameters.get("login"), parameters.get("password"), parameters.get("email")).build();
        return createUserService.execute(user);
    }

}
