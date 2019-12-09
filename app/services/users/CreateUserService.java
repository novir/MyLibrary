package services.users;

import dao.UserDao;
import dto.UserDto;
import models.User;

public class CreateUserService {

    public UserDto execute(UserDto userData) {
        UserDao userDao = new UserDao();
        User modelToPersist = userData.toModel();
        User persistedModel = userDao.save(modelToPersist);
        return persistedModel.toDto();
    }

}
