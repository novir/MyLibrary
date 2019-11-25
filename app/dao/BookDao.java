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
    public void save(Book book) {
        if (book != null) {
            book.save();
        }
    }

    @Override
    public void delete(Book book) {
        if (book != null) {
            book.delete();
        }
    }

    public static List<Book> findTaggedWith(String tagName) {
        return Book.find(
                "select distinct book from Book as book join book.tags as tags where t.name = ?", tagName
        ).fetch();
    }

}
