package models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Entity
@SQLDelete(sql="Update tag SET is_deleted = 1, deleted_at = CURRENT_DATE where id = ?")
@Where(clause="is_deleted != 1")
public class Tag extends MetaModel implements Comparable<Tag> {

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy="tags", cascade=CascadeType.PERSIST)
    private List<Book> books;

    public Tag(String name, Book... taggedBooks) {
        this.name = name;
        initBooksCollection(taggedBooks);
    }

    private void initBooksCollection(Book... taggedBooks) {
        books = new LinkedList<>();
        Collections.addAll(books, taggedBooks);
    }

    @Override
    public int compareTo(Tag otherTag) {
        return name.compareTo(otherTag.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

}
