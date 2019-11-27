package services.users;

import dao.UserDao;
import models.User;

import java.util.List;

public class ListUsersService {

    public List<User> execute() {
        UserDao userDao = new UserDao();
        return userDao.findAll();
    }

}
