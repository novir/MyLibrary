package dao;

import models.Tag;
import play.db.jpa.Model;

import java.util.List;
import java.util.Optional;

public class TagDao<T extends Model> implements DaoInterface<T> {

    @Override
    public Optional<T> find(long id) {
        if (id < 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(Tag.findById(id));
    }

    @Override
    public List<T> findAll() {
        return Tag.findAll();
    }

    @Override
    public T save(T tag) {
        return tag != null ? tag.save() : null;
    }

    @Override
    public T delete(T tag) {
        return tag != null ? tag.delete() : null;
    }

}
