package services.users;

import dao.UserDao;
import models.User;

import java.util.Optional;

public class GetUserService {

    public Optional<User> execute(long id) {
        UserDao userDao = new UserDao();
        return userDao.find(id);
    }

}
