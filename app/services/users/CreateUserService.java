package services.users;

import dao.DaoInterface;
import dao.UserDao;
import dto.UserDto;
import models.User;

public class CreateUserService {

    private final DaoInterface<User> dao = new UserDao<>();

    public UserDto execute(UserDto userData) {
        User modelToPersist = userData.toModel();
        User persistedModel = dao.save(modelToPersist);
        return persistedModel.toDto();
    }

}
