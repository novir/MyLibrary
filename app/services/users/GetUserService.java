package services.users;

import dao.UserDao;
import dto.UserDto;
import models.Book;
import models.User;

import java.util.List;
import java.util.Optional;

public class GetUserService {

    public Optional<UserDto> execute(long id) {
        UserDao userDao = new UserDao();
        return userDao.find(id).map(User::toDto);
    }

}
