package dao;

import models.Author;
import play.db.jpa.Model;

import java.util.Collection;
import java.util.Optional;

public class AuthorDao<T extends Model> implements DaoInterface<T> {

    @Override
    public Optional<T> find(long id) {
        if (id < 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(Author.findById(id));
    }

    @Override
    public Collection<T> findAll() {
        return Author.findAll();
    }

    @Override
    public T save(T author) {
        return author != null ? author.save() : null;
    }

    @Override
    public T delete(T author) {
        return author != null ? author.delete() : null;
    }

}
