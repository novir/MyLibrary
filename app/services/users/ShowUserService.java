package services.users;

import dao.DaoInterface;
import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.Optional;

public class ShowUserService {

    private final DaoInterface<User> dao = new UserDao<>();

    public Optional<UserDto> execute(long id) {
        return dao.find(id).map(User::toDto);
    }

}
