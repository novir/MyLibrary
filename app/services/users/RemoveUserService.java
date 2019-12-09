package services.users;

import dao.DaoInterface;
import dao.UserDao;
import dto.UserDto;
import models.User;

import java.util.Optional;

public class RemoveUserService {

    public Optional<UserDto> execute(long id) {
        DaoInterface<User> dao = new UserDao<>();
        Optional<User> modelToDelete = dao.find(id);
        if (modelToDelete.isPresent()) {
            User deletedModel = dao.delete(modelToDelete.get());
            return Optional.of(deletedModel.toDto());
        }
        return Optional.empty();
    }

}
