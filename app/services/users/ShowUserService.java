package services.users;

import dao.DaoInterface;
import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.Optional;

public class ShowUserService {

    public Optional<UserDto> execute(long id) {
        DaoInterface<User> dao = new UserDao<>();
        return dao.find(id).map(User::toDto);
    }

}
