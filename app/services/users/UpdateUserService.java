package services.users;

import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.Optional;

public class UpdateUserService {

    public Optional<UserDto> execute(long id, UserDto userData) {
        UserDao userDao = new UserDao();
        Optional<User> modelToUpdate = userDao.find(id);
        if (modelToUpdate.isPresent()) {
            User user = modelToUpdate.get();
            user.fillWith(userData.toModel());
            User updatedModel = userDao.save(user);
            return Optional.of(updatedModel.toDto());
        }
        return Optional.empty();
    }


}
