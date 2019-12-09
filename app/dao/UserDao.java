package dao;

import models.User;
import play.db.jpa.Model;

import java.util.Collection;
import java.util.Optional;

public class UserDao<T extends Model> implements DaoInterface<T> {

    @Override
    public Optional<T> find(long id) {
        if (id < 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(User.findById(id));
    }

    @Override
    public Collection<T> findAll() {
        return User.findAll();
    }

    @Override
    public T save(T user) {
        return user != null ? user.save() : null;
    }

    @Override
    public T delete(T user) {
        return user != null ? user.delete() : null;
    }

}
