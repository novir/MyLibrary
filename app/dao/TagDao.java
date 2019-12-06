package dao;

import models.Book;
import models.Tag;

import java.util.List;
import java.util.Optional;

public class TagDao implements DaoInterface<Tag> {

    @Override
    public Optional<Tag> find(long id) {
        if (id < 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(Tag.findById(id));
    }

    @Override
    public List<Tag> findAll() {
        return Tag.findAll();
    }

    @Override
    public Tag save(Tag tag) {
        return tag != null ? tag.save() : null;
    }

    @Override
    public Tag delete(Tag tag) {
        return tag != null ? tag.delete() : null;
    }

    public static Tag findOrCreateByName(String name, Book... taggedBooks) {
        Tag tag = Tag.find("byName", name).first();
        if(tag == null) {
            tag = new Tag(name, taggedBooks);
        }
        return tag;
    }
}
