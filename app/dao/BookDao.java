package dao;

import models.Book;
import play.db.jpa.Model;

import java.util.List;
import java.util.Optional;

public class BookDao<T extends Model> implements DaoInterface<T> {

    @Override
    public Optional<T> find(long id) {
        if (id < 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(Book.findById(id));
    }

    @Override
    public List<T> findAll() {
        return Book.findAll();
    }

    @Override
    public T save(T book) {
        return book != null ? book.save() : null;
    }

    @Override
    public T delete(T book) {
        return book != null ? book.delete() : null;
    }

    public List<T> findAllTaggedWith(String tagName) {
        return Book.find(
                "select distinct book from Book as book join book.tags as tags where t.name = ?", tagName
        ).fetch();
    }

}
