package services.users;

import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.List;
import java.util.stream.Collectors;

public class ListUsersService {

    public List<UserDto> execute() {
        UserDao userDao = new UserDao();
        return userDao.findAll()
                .stream()
                .map(User::toDto)
                .collect(Collectors.toList());
    }

}
