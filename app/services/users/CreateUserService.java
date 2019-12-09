package services.users;

import dao.DaoInterface;
import dao.UserDao;
import dto.UserDto;
import models.User;

public class CreateUserService {

    public UserDto execute(UserDto userData) {
        DaoInterface<User> dao = new UserDao<>();
        User modelToPersist = userData.toModel();
        User persistedModel = dao.save(modelToPersist);
        return persistedModel.toDto();
    }

}
