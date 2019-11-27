package actions.users;

import models.User;
import services.users.GetUserService;
import services.users.ListUsersService;

import java.util.Optional;

public class GetUserAction {

    public String execute(long id) {
        GetUserService getUserService = new GetUserService();
        return getUserService.execute(id).map(User::toJson).orElse("{}");
    }

}
