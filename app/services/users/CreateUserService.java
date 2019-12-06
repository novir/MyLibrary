package services.users;

import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.Optional;

public class CreateUserService {

    public UserDto execute(UserDto user) {
        UserDao userDao = new UserDao();
        return userDao.save(user.toModel()).toDto();
    }

}
