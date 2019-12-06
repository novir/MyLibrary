package services.users;

import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.Optional;

public class RemoveUserService {

    public Optional<UserDto> execute(long id) {
        UserDao userDao = new UserDao();
        Optional<User> userToDelete = userDao.find(id);
        if (userToDelete.isPresent()) {
            User deletedUser = userDao.delete(userToDelete.get());
            return Optional.of(deletedUser.toDto());
        }
        return Optional.empty();
    }

}
