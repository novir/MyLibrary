package services.users;

import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.Optional;

public class RemoveUserService {

    public Optional<UserDto> execute(long id) {
        UserDao userDao = new UserDao();
        Optional<User> modelToDelete = userDao.find(id);
        if (modelToDelete.isPresent()) {
            User deletedModel = userDao.delete(modelToDelete.get());
            return Optional.of(deletedModel.toDto());
        }
        return Optional.empty();
    }

}
