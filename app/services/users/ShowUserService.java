package services.users;

import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.Optional;

public class ShowUserService {

    public Optional<UserDto> execute(long id) {
        UserDao userDao = new UserDao();
        return userDao.find(id).map(User::toDto);
    }

}
