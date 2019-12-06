package dao;

import models.Book;

import java.util.List;
import java.util.Optional;

public class BookDao implements DaoInterface<Book> {

    @Override
    public Optional<Book> find(long id) {
        if (id < 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(Book.findById(id));
    }

    @Override
    public List<Book> findAll() {
        return Book.findAll();
    }

    @Override
    public Book save(Book book) {
        return book != null ? book.save() : null;
    }

    @Override
    public Book delete(Book book) {
        return book != null ? book.delete() : null;
    }

    public static List<Book> findAllTaggedWith(String tagName) {
        return Book.find(
                "select distinct book from Book as book join book.tags as tags where t.name = ?", tagName
        ).fetch();
    }

}
