package dao;

import models.User;

import java.util.List;
import java.util.Optional;

public class UserDao implements DaoInterface<User> {

    @Override
    public Optional<User> find(long id) {
        if (id < 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(User.findById(id));
    }

    @Override
    public List<User> findAll() {
        return User.findAll();
    }

    @Override
    public void save(User user) {
        if (user != null) {
            user.save();
        }
    }

    @Override
    public void delete(User user) {
        if (user != null) {
            user.delete();
        }
    }

}
