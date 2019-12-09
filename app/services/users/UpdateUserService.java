package services.users;

import dao.DaoInterface;
import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.Optional;

public class UpdateUserService {

    public Optional<UserDto> execute(long id, UserDto userData) {
        DaoInterface<User> dao = new UserDao<>();
        Optional<User> modelToUpdate = dao.find(id);
        if (modelToUpdate.isPresent()) {
            User user = modelToUpdate.get();
            user.fillWith(userData.toModel());
            User updatedModel = dao.save(user);
            return Optional.of(updatedModel.toDto());
        }
        return Optional.empty();
    }


}
