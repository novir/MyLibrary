package dao;

import models.Author;

import java.util.Collection;
import java.util.Optional;

public class AuthorDao implements DaoInterface<Author> {

    @Override
    public Optional<Author> find(long id) {
        if (id < 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(Author.findById(id));
    }

    @Override
    public Collection<Author> findAll() {
        return Author.findAll();
    }

    @Override
    public Author save(Author author) {
        return author != null ? author.save() : null;
    }

    @Override
    public Author delete(Author author) {
        return author != null ? author.delete() : null;
    }

}
