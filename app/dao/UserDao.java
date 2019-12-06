package dao;

import models.User;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class UserDao implements DaoInterface<User> {

    @Override
    public Optional<User> find(long id) {
        if (id < 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(User.findById(id));
    }

    @Override
    public Collection<User> findAll() {
        return User.findAll();
    }

    @Override
    public User save(User user) {
        return user != null ? user.save() : null;
    }

    @Override
    public User delete(User user) {
        return user != null ? user.delete() : null;
    }

}
