package services.users;

import dao.DaoInterface;
import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.Optional;

public class UpdateUserService {

    private final DaoInterface<User> dao = new UserDao<>();

    public Optional<UserDto> execute(long id, UserDto userData) {
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
