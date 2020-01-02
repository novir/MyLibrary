package services.users;

import dao.DaoInterface;
import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.List;
import java.util.stream.Collectors;

public class ListUsersService {

    private final DaoInterface<User> dao = new UserDao<>();

    public List<UserDto> execute() {
        return dao.findAll()
                .stream()
                .map(User::toDto)
                .collect(Collectors.toList());
    }

}
